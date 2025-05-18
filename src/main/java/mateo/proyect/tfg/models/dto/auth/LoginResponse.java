package mateo.proyect.tfg.models.dto.auth;

import mateo.proyect.tfg.models.dto.user.UserView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class LoginResponse {
    private String token;
    private UserView user;
}