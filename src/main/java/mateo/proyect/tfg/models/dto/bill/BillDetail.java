package mateo.proyect.tfg.models.dto.bill;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BillDetail {

    private Integer id;

    // Destinatario
    private String destinatarioDenomSocial;
    private String destinatarioNif;
    private String destinatarioDIR;
    private String destinatarioDireccionFiscal;

    // Emisor
    private String emisorDenomSocial;
    private String emisorNif;
    private String emisorDireccionFiscal;
    // Datos de la factura
    private String serie;
    private String numeroCorrelativo;
    private String fechaEmision;
    private String fechaVencimiento;
    private String concepto;
    private String albaranes;
    private String tipoIVA;
    private String tipoRetencion;
    private String baseFactura;
    private String importeFinal;
    private String formaPago;
    private String fechaPago;
}
