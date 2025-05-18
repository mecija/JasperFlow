package mateo.proyect.tfg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import mateo.proyect.tfg.models.db.ProductDB;

public interface ProductRepository extends JpaRepository<ProductDB, Integer>, 
        JpaSpecificationExecutor<ProductDB> {

}