package mateo.proyect.tfg.models.dto.order;

import java.util.List;
import lombok.*;
import mateo.proyect.tfg.models.db.ProductDB;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderList {

    private Integer orderId;
    private Integer clientId;
    private String orderStatus;
    private Integer amount;
    private List<OrderProductDTO> productos;

}