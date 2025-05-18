package mateo.proyect.tfg.models.db;

import java.time.LocalDateTime;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FichajeDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String employeeId;
    private LocalDateTime initialTime;
    @Nullable
    private LocalDateTime exitTime;
    @Nullable
    private String initialLocation;
    @Nullable
    private String exitLocation;

}
