package mateo.proyect.tfg.models.db;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDB {

    private LocalDateTime creationTime;
    private LocalDateTime deliveryTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private Integer clientId;
    private String orderStatus;
    private Integer amount;
    private String deliveryAddress;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProductDB> orderProducts = new ArrayList<>();

}
