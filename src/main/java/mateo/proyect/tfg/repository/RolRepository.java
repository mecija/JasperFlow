package mateo.proyect.tfg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import mateo.proyect.tfg.models.db.RolDB;

public interface RolRepository extends JpaRepository<RolDB, Integer>,
                JpaSpecificationExecutor<RolDB> {
        Optional<RolDB> findByName(String name);
}