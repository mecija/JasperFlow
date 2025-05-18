package mateo.proyect.tfg.specification;

import mateo.proyect.tfg.models.db.UserDB;
import mateo.proyect.tfg.filters.UserFilter;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class UserSpecification {

    public static Specification<UserDB> filterBy(UserFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtrar por nombre
            if (filter.getName() != null && !filter.getName().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + filter.getName() + "%"));
            }

            // Filtrar por email
            if (filter.getEmail() != null && !filter.getEmail().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("email"), "%" + filter.getEmail() + "%"));
            }

            // Filtrar por estado habilitado/deshabilitado
            if (filter.getEnabled() != null) {
                predicates.add(criteriaBuilder.equal(root.get("enabled"), filter.getEnabled()));
            }

            // Filtrar por fecha de creación (rango)
            if (filter.getCreatedAtStart() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), filter.getCreatedAtStart()));
            }
            if (filter.getCreatedAtEnd() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), filter.getCreatedAtEnd()));
            }

            // Filtrar por última conexión (rango)
            if (filter.getLastLoginStart() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("lastLogin"), filter.getLastLoginStart()));
            }
            if (filter.getLastLoginEnd() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("lastLogin"), filter.getLastLoginEnd()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}