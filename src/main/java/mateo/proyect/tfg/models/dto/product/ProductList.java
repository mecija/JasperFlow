package mateo.proyect.tfg.models.dto.product;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductList {

    private Integer id;
    private String name;
    private String imageUrl;
    private Double price;
    private String category;

}