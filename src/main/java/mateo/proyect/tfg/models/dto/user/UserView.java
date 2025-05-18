package mateo.proyect.tfg.models.dto.user;

import lombok.*;
import mateo.proyect.tfg.models.dto.role.RoleDTO;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserView {
    private Integer id;
    private String name;
    private String email;
    private boolean enabled;
    private Set<RoleDTO> roles;
}