package mateo.proyect.tfg.models.dto.client;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ClientList {

    private Integer id;
    private String nombre;
    private String empresa;
    private String pais;
    private String email;

}
