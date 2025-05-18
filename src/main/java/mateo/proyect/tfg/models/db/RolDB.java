package mateo.proyect.tfg.models.db;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RolDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(nullable = true)
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<UserDB> users;
}