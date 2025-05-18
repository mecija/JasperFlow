package mateo.proyect.tfg.models.dto.order;

import java.time.LocalDateTime;
import java.util.List;

import lombok.*;
import mateo.proyect.tfg.models.db.ProductDB;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderEdit {

    private LocalDateTime creationTime;
    private LocalDateTime deliveryTime;
    private Integer orderId;
    private Integer clientId;
    private String orderStatus;
    private Integer amount;
    private String deliveryAddress;
    private List<OrderProductDTO> productos;

}