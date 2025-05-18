package mateo.proyect.tfg.models.dto.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserLogin {
    private String email;
    private String password;
}