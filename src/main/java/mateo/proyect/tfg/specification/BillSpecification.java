package mateo.proyect.tfg.specification;

import mateo.proyect.tfg.models.db.BillDB;
import mateo.proyect.tfg.filters.BillFilter;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

public class BillSpecification {

    public static Specification<BillDB> filterBy(BillFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getDestinatarioDenomSocial() != null && !filter.getDestinatarioDenomSocial().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("destinatarioDenomSocial"), "%" + filter.getDestinatarioDenomSocial() + "%"));
            }

            if (filter.getDestinatarioNif() != null && !filter.getDestinatarioNif().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("destinatarioNif"), filter.getDestinatarioNif()));
            }

            if (filter.getDestinatarioDireccionFiscal() != null && !filter.getDestinatarioDireccionFiscal().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("destinatarioDireccionFiscal"), "%" + filter.getDestinatarioDireccionFiscal() + "%"));
            }

            if (filter.getEmisorDenomSocial() != null && !filter.getEmisorDenomSocial().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("emisorDenomSocial"), "%" + filter.getEmisorDenomSocial() + "%"));
            }

            if (filter.getEmisorNif() != null && !filter.getEmisorNif().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("emisorNif"), filter.getEmisorNif()));
            }

            if (filter.getNumeroCorrelativo() != null && !filter.getNumeroCorrelativo().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("numeroCorrelativo"), filter.getNumeroCorrelativo()));
            }


            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}