package mateo.proyect.tfg.filters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillFilter {
    private Integer id;
    private String destinatarioDenomSocial; // Filtrar por denominación social del destinatario
    private String destinatarioNif;         // Filtrar por NIF del destinatario
    private String destinatarioDireccionFiscal; // Filtrar por dirección fiscal del destinatario
    private String emisorDenomSocial;       // Filtrar por denominación social del emisor
    private String emisorNif;               // Filtrar por NIF del emisor
    private String numeroCorrelativo;       // Filtrar por número correlativo de la factura
}
