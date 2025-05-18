package mateo.proyect.tfg.models.dto.user;

import lombok.*;

import java.util.ArrayList;

import mateo.proyect.tfg.models.db.RolDB;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserEdit {

    private Integer id;
    private ArrayList<RolDB> roles;
    private String name;
    private String email;
    private boolean enabled;

}