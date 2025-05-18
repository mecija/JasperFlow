package mateo.proyect.tfg.models.dto.user;

import java.time.LocalDateTime;
import java.util.ArrayList;

import lombok.*;
import mateo.proyect.tfg.models.db.RolDB;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDetail {

    private Integer id;
    private ArrayList<RolDB> roles;
    private String name;
    private String email;
    private boolean enabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLogin;

}