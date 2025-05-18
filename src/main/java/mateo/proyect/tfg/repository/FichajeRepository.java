package mateo.proyect.tfg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import mateo.proyect.tfg.models.db.FichajeDB;

public interface FichajeRepository extends JpaRepository<FichajeDB, Integer>, 
        JpaSpecificationExecutor<FichajeDB> {

}