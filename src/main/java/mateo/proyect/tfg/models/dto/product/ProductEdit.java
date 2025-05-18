package mateo.proyect.tfg.models.dto.product;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductEdit {

    private Integer id;
    private String name;
    private String description;
    private String imageUrl;
    private String category;
    private Integer stock;
    private Double price;

}