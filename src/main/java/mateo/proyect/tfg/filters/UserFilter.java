package mateo.proyect.tfg.filters;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserFilter {
    private Integer id;
    private String name;                  // Filtrar por nombre
    private String email;                 // Filtrar por email
    private Boolean enabled;              // Filtrar por estado habilitado/deshabilitado
    private LocalDateTime createdAtStart; // Filtrar por fecha de creación (inicio)
    private LocalDateTime createdAtEnd;   // Filtrar por fecha de creación (fin)
    private LocalDateTime lastLoginStart; // Filtrar por última conexión (inicio)
    private LocalDateTime lastLoginEnd;   // Filtrar por última conexión (fin)
}