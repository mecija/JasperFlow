package mateo.proyect.tfg.filters;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FichajeFilter {
    private Integer id;
    private Integer employeeId;               // Filtrar por ID del empleado
    private LocalDateTime initialTimeStart;  // Filtrar por hora inicial (inicio)
    private LocalDateTime initialTimeEnd;    // Filtrar por hora inicial (fin)
    private LocalDateTime exitTimeStart;     // Filtrar por hora de salida (inicio)
    private LocalDateTime exitTimeEnd;       // Filtrar por hora de salida (fin)
    private String initialLocation;          // Filtrar por ubicación inicial
    private String exitLocation;             // Filtrar por ubicación de salida
}