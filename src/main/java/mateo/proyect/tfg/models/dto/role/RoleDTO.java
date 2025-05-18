package mateo.proyect.tfg.models.dto.role;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RoleDTO {
    private Integer id;
    private String name;
    private String description;
}