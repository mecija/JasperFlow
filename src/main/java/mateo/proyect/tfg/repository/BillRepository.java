package mateo.proyect.tfg.repository;

import mateo.proyect.tfg.models.db.BillDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BillRepository extends JpaRepository<BillDB, Integer>, JpaSpecificationExecutor<BillDB> {
}