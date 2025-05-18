package mateo.proyect.tfg.models.dto.client;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ClientDetail {

    private Integer id;
    private String dni;
    private String nombre;
    private String empresa;
    private String pais;
    private String direccion;
    private String email;
    private String telefono;

}