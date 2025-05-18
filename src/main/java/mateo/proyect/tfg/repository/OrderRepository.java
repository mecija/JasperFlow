package mateo.proyect.tfg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import mateo.proyect.tfg.models.db.OrderDB;

public interface OrderRepository extends JpaRepository<OrderDB, Integer>, 
        JpaSpecificationExecutor<OrderDB> {

}