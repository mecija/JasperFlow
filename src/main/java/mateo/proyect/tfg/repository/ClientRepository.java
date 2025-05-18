package mateo.proyect.tfg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import mateo.proyect.tfg.models.db.ClientDB;

public interface ClientRepository extends JpaRepository<ClientDB, Integer>,
        JpaSpecificationExecutor<ClientDB> {

}
