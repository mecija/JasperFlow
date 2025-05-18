package mateo.proyect.tfg.specification;

import mateo.proyect.tfg.models.db.OrderDB;
import mateo.proyect.tfg.filters.OrderFilter;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class OrderSpecification {

    public static Specification<OrderDB> filterBy(OrderFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), filter.getId()));
            }
            // Filtrar por fecha de creación (rango)
            if (filter.getCreationTimeStart() != null) {
                predicates.add(
                        criteriaBuilder.greaterThanOrEqualTo(root.get("creationTime"), filter.getCreationTimeStart()));
            }
            if (filter.getCreationTimeEnd() != null) {
                predicates
                        .add(criteriaBuilder.lessThanOrEqualTo(root.get("creationTime"), filter.getCreationTimeEnd()));
            }

            // Filtrar por fecha de entrega (rango)
            if (filter.getDeliveryTimeStart() != null) {
                predicates.add(
                        criteriaBuilder.greaterThanOrEqualTo(root.get("deliveryTime"), filter.getDeliveryTimeStart()));
            }
            if (filter.getDeliveryTimeEnd() != null) {
                predicates
                        .add(criteriaBuilder.lessThanOrEqualTo(root.get("deliveryTime"), filter.getDeliveryTimeEnd()));
            }

            // Filtrar por ID del cliente
            if (filter.getClientId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("clientId"), filter.getClientId()));
            }

            // Filtrar por estado del pedido
            if (filter.getOrderStatus() != null && !filter.getOrderStatus().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("orderStatus"), filter.getOrderStatus()));
            }

            // Filtrar por monto (rango)
            if (filter.getMinAmount() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("amount"), filter.getMinAmount()));
            }
            if (filter.getMaxAmount() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("amount"), filter.getMaxAmount()));
            }

            // Filtrar por dirección de entrega
            if (filter.getDeliveryAddress() != null && !filter.getDeliveryAddress().isEmpty()) {
                predicates.add(
                        criteriaBuilder.like(root.get("deliveryAddress"), "%" + filter.getDeliveryAddress() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}