package mateo.proyect.tfg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import mateo.proyect.tfg.models.db.UserDB;

public interface UserRepository extends JpaRepository<UserDB, Integer>,
                JpaSpecificationExecutor<UserDB> {
                        
        Optional<UserDB> findByEmail(String email);
}