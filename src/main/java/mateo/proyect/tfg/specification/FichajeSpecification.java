package mateo.proyect.tfg.specification;

import mateo.proyect.tfg.models.db.FichajeDB;
import mateo.proyect.tfg.filters.FichajeFilter;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class FichajeSpecification {

    public static Specification<FichajeDB> filterBy(FichajeFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtrar por ID del empleado
            if (filter.getEmployeeId() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("employeeId"), filter.getEmployeeId()));
            }

            // Filtrar por hora inicial (rango)
            if (filter.getInitialTimeStart() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("initialTime"), filter.getInitialTimeStart()));
            }
            if (filter.getInitialTimeEnd() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("initialTime"), filter.getInitialTimeEnd()));
            }

            // Filtrar por hora de salida (rango)
            if (filter.getExitTimeStart() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("exitTime"), filter.getExitTimeStart()));
            }
            if (filter.getExitTimeEnd() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("exitTime"), filter.getExitTimeEnd()));
            }

            // Filtrar por ubicación inicial
            if (filter.getInitialLocation() != null && !filter.getInitialLocation().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("initialLocation"), "%" + filter.getInitialLocation() + "%"));
            }

            // Filtrar por ubicación de salida
            if (filter.getExitLocation() != null && !filter.getExitLocation().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("exitLocation"), "%" + filter.getExitLocation() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}