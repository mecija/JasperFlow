package mateo.proyect.tfg.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mateo.proyect.tfg.exception.EntityAlreadyExistsException;
import mateo.proyect.tfg.exception.EntityIllegalArgumentException;
import mateo.proyect.tfg.exception.EntityNotFoundException;
import mateo.proyect.tfg.filters.ProductFilter;
import mateo.proyect.tfg.mapper.ProductMapper;
import mateo.proyect.tfg.models.db.ProductDB;
import mateo.proyect.tfg.models.dto.product.ProductEdit;
import mateo.proyect.tfg.repository.ProductRepository;
import mateo.proyect.tfg.service.intrf.ProductServiceIF;
import mateo.proyect.tfg.specification.ProductSpecification;

@Service
public class ProductService implements ProductServiceIF {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<ProductEdit> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(ProductMapper.INSTANCE::toProductEdit);
    }

    @Override
    public Page<ProductEdit> findAllWithFilters(ProductFilter filter, Pageable pageable) {
        return repository.findAll(ProductSpecification.filterBy(filter), pageable)
                .map(ProductMapper.INSTANCE::toProductEdit);
    }

    @Override
    public ProductEdit create(ProductEdit obj) {
        if (obj.getId() != null) {
            throw new EntityAlreadyExistsException("Entity_Already_Exists",
                    "La entidad con id " + obj.getId() + " ya existe");
        }
        ProductDB entity = ProductMapper.INSTANCE.toProductDB(obj);
        return ProductMapper.INSTANCE.toProductEdit(repository.save(entity));
    }

    @Override
    public ProductEdit read(Integer id) {
        ProductDB entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OBJECT_NOT_FOUND", "Product not found with id: " + id));
        return ProductMapper.INSTANCE.toProductEdit(entity);
    }

    @Override
    public ProductEdit update(Integer id, ProductEdit obj) {
        if (!id.equals(obj.getId())) {
            throw new EntityIllegalArgumentException("id_mismatch",
                    "El id proporcionado no coincide con el id del objeto a actualizar.");
        }
        ProductDB existingEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OBJECT_NOT_FOUND",
                        "No se puede actualizar, el objeto con el id: " + id + " no existe."));
        ProductMapper.INSTANCE.updateProductFromEdit(obj, existingEntity);
        return ProductMapper.INSTANCE.toProductEdit(repository.save(existingEntity));
    }

    @Override
    public void delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}