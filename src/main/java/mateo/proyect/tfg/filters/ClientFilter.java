package mateo.proyect.tfg.filters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientFilter {
    private Integer id;
    private String dni; // Filtrar por DNI
    private String nombre; // Filtrar por nombre
    private String empresa; // Filtrar por empresa
    private String pais; // Filtrar por país
    private String direccion; // Filtrar por zona
}