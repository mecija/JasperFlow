package mateo.proyect.tfg.service.intrf;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mateo.proyect.tfg.filters.OrderFilter;
import mateo.proyect.tfg.models.db.OrderDB;
import mateo.proyect.tfg.models.dto.order.OrderEdit;

public interface OrderServiceIF {

    public OrderEdit create(OrderEdit obj);
    public OrderEdit read(Integer id);
    public OrderEdit update(Integer id, OrderEdit obj);
    public void delete(Integer id);

    Page<OrderEdit> findAll(Pageable pageable);
    Page<OrderEdit> findAllWithFilters(OrderFilter filter, Pageable pageable);
}