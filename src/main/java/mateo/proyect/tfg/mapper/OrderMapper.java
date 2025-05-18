package mateo.proyect.tfg.mapper;

import mateo.proyect.tfg.models.db.OrderDB;
import mateo.proyect.tfg.models.db.OrderProductDB;
import mateo.proyect.tfg.models.dto.order.OrderDetail;
import mateo.proyect.tfg.models.dto.order.OrderList;
import mateo.proyect.tfg.models.dto.order.OrderEdit;
import mateo.proyect.tfg.models.dto.order.OrderProductDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "productos", source = "orderProducts")
    OrderEdit toOrderEdit(OrderDB orderDB);

    @Mapping(target = "productos", source = "orderProducts")
    OrderDetail toOrderDetail(OrderDB orderDB);

    OrderList toOrderList(OrderDB orderDB);

    OrderDB toOrderDB(OrderEdit orderEdit);

    void updateOrderFromEdit(OrderEdit orderEdit, @MappingTarget OrderDB orderDB);

    // Método auxiliar para mapear la lista de OrderProductDB a OrderProductDTO
    default List<OrderProductDTO> mapOrderProducts(List<OrderProductDB> orderProducts) {
        if (orderProducts == null) return null;
        return orderProducts.stream()
                .map(op -> new OrderProductDTO(
                        op.getProduct().getId(),
                        op.getCantidad()
                ))
                .collect(Collectors.toList());
    }
}