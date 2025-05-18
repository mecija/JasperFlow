package mateo.proyect.tfg.models.dto.user;

import lombok.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserRegister {

    private String name;
    private String email;
    private String password;
    private Set<Integer> roleIds; // IDs de los roles asignados
}