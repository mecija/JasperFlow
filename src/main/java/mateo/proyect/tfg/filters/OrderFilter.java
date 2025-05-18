package mateo.proyect.tfg.filters;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderFilter {
    private Integer id;
    private LocalDateTime creationTimeStart; // Filtrar por fecha de creación (inicio)
    private LocalDateTime creationTimeEnd;   // Filtrar por fecha de creación (fin)
    private LocalDateTime deliveryTimeStart; // Filtrar por fecha de entrega (inicio)
    private LocalDateTime deliveryTimeEnd;   // Filtrar por fecha de entrega (fin)
    private Integer clientId;                 // Filtrar por ID del cliente
    private String orderStatus;              // Filtrar por estado del pedido
    private Integer minAmount;               // Filtrar por monto mínimo
    private Integer maxAmount;               // Filtrar por monto máximo
    private String deliveryAddress;          // Filtrar por dirección de entrega
}