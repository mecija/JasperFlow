package mateo.proyect.tfg.specification;

import mateo.proyect.tfg.models.db.ClientDB;
import mateo.proyect.tfg.filters.ClientFilter;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ClientSpecification {

    public static Specification<ClientDB> filterBy(ClientFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), filter.getId()));
            }

            // Filtrar por DNI
            if (filter.getDni() != null && !filter.getDni().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("dni"), filter.getDni()));
            }

            // Filtrar por nombre
            if (filter.getNombre() != null && !filter.getNombre().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("nombre"), "%" + filter.getNombre() + "%"));
            }

            // Filtrar por empresa
            if (filter.getEmpresa() != null && !filter.getEmpresa().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("empresa"), "%" + filter.getEmpresa() + "%"));
            }

            // Filtrar por país
            if (filter.getPais() != null && !filter.getPais().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("pais"), "%" + filter.getPais() + "%"));
            }

            if (filter.getDireccion() != null && !filter.getDireccion().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("direccion"), "%" + filter.getDireccion() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}