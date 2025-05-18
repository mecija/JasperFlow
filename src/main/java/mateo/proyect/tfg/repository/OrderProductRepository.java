package mateo.proyect.tfg.repository;

import mateo.proyect.tfg.models.db.OrderProductDB;
import mateo.proyect.tfg.models.db.OrderProductKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProductDB, OrderProductKey> {
}