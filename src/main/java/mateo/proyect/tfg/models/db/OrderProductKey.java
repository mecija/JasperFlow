package mateo.proyect.tfg.models.db;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductKey implements Serializable {
    private Integer orderId;
    private Integer productId;
}