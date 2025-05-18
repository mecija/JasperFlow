package mateo.proyect.tfg.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import mateo.proyect.tfg.exception.EntityAlreadyExistsException;
import mateo.proyect.tfg.exception.EntityIllegalArgumentException;
import mateo.proyect.tfg.exception.EntityNotFoundException;
import mateo.proyect.tfg.filters.OrderFilter;
import mateo.proyect.tfg.mapper.OrderMapper;
import mateo.proyect.tfg.models.db.OrderDB;
import mateo.proyect.tfg.models.db.OrderProductDB;
import mateo.proyect.tfg.models.db.OrderProductKey;
import mateo.proyect.tfg.models.db.ProductDB;
import mateo.proyect.tfg.models.dto.order.OrderEdit;
import mateo.proyect.tfg.models.dto.order.OrderProductDTO;
import mateo.proyect.tfg.repository.OrderRepository;
import mateo.proyect.tfg.repository.ProductRepository;
import mateo.proyect.tfg.repository.OrderProductRepository;
import mateo.proyect.tfg.service.intrf.OrderServiceIF;
import mateo.proyect.tfg.specification.OrderSpecification;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements OrderServiceIF {

    private final OrderRepository repository;
    private final ProductRepository productRepository;
    private final OrderProductRepository orderProductRepository;

    public OrderService(OrderRepository repository, ProductRepository productRepository,
            OrderProductRepository orderProductRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public Page<OrderEdit> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(OrderMapper.INSTANCE::toOrderEdit);
    }

    @Override
    public Page<OrderEdit> findAllWithFilters(OrderFilter filter, Pageable pageable) {
        return repository.findAll(OrderSpecification.filterBy(filter), pageable)
                .map(OrderMapper.INSTANCE::toOrderEdit);
    }

    @Override
    @Transactional
    public OrderEdit create(OrderEdit obj) {
        if (obj.getOrderId() != null) {
            throw new EntityAlreadyExistsException("Entity_Already_Exists",
                    "La entidad con id " + obj.getOrderId() + " ya existe");
        }
        OrderDB order = OrderMapper.INSTANCE.toOrderDB(obj);

        // Guarda primero el pedido para obtener el ID
        order = repository.save(order);

        // Relaciona productos y cantidades
        List<OrderProductDB> orderProducts = new ArrayList<>();
        if (obj.getProductos() != null) {
            for (OrderProductDTO dto : obj.getProductos()) {
                ProductDB product = productRepository.findById(dto.getId())
                        .orElseThrow(() -> new EntityNotFoundException("PRODUCT_NOT_FOUND",
                                "Producto no encontrado con id: " + dto.getId()));
                OrderProductDB op = new OrderProductDB();
                op.setOrder(order);
                op.setProduct(product);
                op.setCantidad(dto.getAmount());
                op.setId(new OrderProductKey(order.getOrderId(), product.getId()));
                orderProducts.add(op);
            }
            orderProductRepository.saveAll(orderProducts);
            // No asignes la lista a order.setOrderProducts(orderProducts) aquí
        }

        return OrderMapper.INSTANCE.toOrderEdit(order);
    }

    @Override
    public OrderEdit read(Integer id) {
        OrderDB entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OBJECT_NOT_FOUND", "Order not found with id: " + id));
        return OrderMapper.INSTANCE.toOrderEdit(entity);
    }

    @Override
    @Transactional
    public OrderEdit update(Integer id, OrderEdit obj) {
        if (!id.equals(obj.getOrderId())) {
            throw new EntityIllegalArgumentException("id_mismatch",
                    "El id proporcionado no coincide con el id del objeto a actualizar.");
        }
        OrderDB existingEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OBJECT_NOT_FOUND",
                        "No se puede actualizar, el objeto con el id: " + id + " no existe."));

        // Elimina relaciones antiguas
        orderProductRepository.deleteAll(existingEntity.getOrderProducts());
        existingEntity.getOrderProducts().clear();

        // Actualiza los campos básicos
        OrderMapper.INSTANCE.updateOrderFromEdit(obj, existingEntity);

        // Añade nuevas relaciones producto-cantidad
        List<OrderProductDB> orderProducts = new ArrayList<>();
        if (obj.getProductos() != null) {
            for (OrderProductDTO dto : obj.getProductos()) {
                ProductDB product = productRepository.findById(dto.getId())
                        .orElseThrow(() -> new EntityNotFoundException("PRODUCT_NOT_FOUND",
                                "Producto no encontrado con id: " + dto.getId()));
                OrderProductDB op = new OrderProductDB();
                op.setOrder(existingEntity);
                op.setProduct(product);
                op.setCantidad(dto.getAmount());
                op.setId(new OrderProductKey(existingEntity.getOrderId(), product.getId()));
                orderProducts.add(op);
            }
            orderProductRepository.saveAll(orderProducts);
            // No asignes la lista a existingEntity.setOrderProducts(orderProducts) aquí
        }

        return OrderMapper.INSTANCE.toOrderEdit(repository.save(existingEntity));
    }

    @Override
    public void delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}