package mateo.proyect.tfg.models.db;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderProductDB {

    @EmbeddedId
    private OrderProductKey id = new OrderProductKey();

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private OrderDB order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductDB product;

    private Integer cantidad;
}