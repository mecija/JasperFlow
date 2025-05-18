package mateo.proyect.tfg.filters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductFilter {
    private Integer id;
    private String name;        // Filtrar por nombre del producto
    private String category;    // Filtrar por categoría del producto
    private Double minPrice;    // Filtrar por precio mínimo
    private Double maxPrice;    // Filtrar por precio máximo
    private Integer minStock;   // Filtrar por stock mínimo
    private Integer maxStock;   // Filtrar por stock máximo
}