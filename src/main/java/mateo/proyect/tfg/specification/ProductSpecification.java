package mateo.proyect.tfg.specification;

import mateo.proyect.tfg.models.db.ProductDB;
import mateo.proyect.tfg.filters.ProductFilter;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecification {

    public static Specification<ProductDB> filterBy(ProductFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

     
            if (filter.getId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), filter.getId()));
            }

            // Filtrar por nombre del producto
            if (filter.getName() != null && !filter.getName().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + filter.getName() + "%"));
            }

            // Filtrar por categoría del producto
            if (filter.getCategory() != null && !filter.getCategory().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("category"), "%" + filter.getCategory() + "%"));
            }

            // Filtrar por precio mínimo
            if (filter.getMinPrice() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), filter.getMinPrice()));
            }

            // Filtrar por precio máximo
            if (filter.getMaxPrice() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), filter.getMaxPrice()));
            }

            // Filtrar por stock mínimo
            if (filter.getMinStock() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("stock"), filter.getMinStock()));
            }

            // Filtrar por stock máximo
            if (filter.getMaxStock() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("stock"), filter.getMaxStock()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}