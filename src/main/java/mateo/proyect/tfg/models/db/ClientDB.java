package mateo.proyect.tfg.models.db;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
@Entity

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ClientDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dni;
    private String nombre;
    private String empresa;
    private String pais;
    @Nullable
    private String direccion;
    private String email;
    private String telefono;

}
