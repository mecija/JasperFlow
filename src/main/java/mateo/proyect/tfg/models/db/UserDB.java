package mateo.proyect.tfg.models.db;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles", // Tabla intermedia
        joinColumns = @JoinColumn(name = "user_id"), // Clave foránea hacia UserDB
        inverseJoinColumns = @JoinColumn(name = "role_id") // Clave foránea hacia RolDB
    )
    private Set<RolDB> roles;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private boolean enabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLogin;
    private String verificationToken;
}
