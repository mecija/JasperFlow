package mateo.proyect.tfg.models.dto.user;

import lombok.*;

import java.util.ArrayList;

import mateo.proyect.tfg.models.db.RolDB;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserList {

    private Integer id;
    private String name;
    private String email;
    private ArrayList<RolDB> roles;
    private boolean enabled;

}