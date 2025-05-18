package mateo.proyect.tfg.models.dto.fichaje;

import java.time.LocalDateTime;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FichajeEdit {

    private Integer id;
    private Integer employeeId;
    private LocalDateTime initialTime;
    private LocalDateTime exitTime;
    private String initialLocation;
    private String exitLocation;

}