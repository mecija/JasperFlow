package mateo.proyect.tfg.models.dto.order;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderProductDTO {
    private Integer id;     // ID del producto
    private Integer amount; // Cantidad de ese producto en el pedido
}