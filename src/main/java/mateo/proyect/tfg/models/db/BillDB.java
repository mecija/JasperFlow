package mateo.proyect.tfg.models.db;

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
public class BillDB {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //destinatario
    private String destinatarioDenomSocial;
    private String destinatarioNif;
    private String destinatarioDIR;
    private String destinatarioDireccionFiscal;

    //emisor
    private String emisorDenomSocial;
    private String emisorNif;
    private String emisorDireccionFiscal;

    //datos factura
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
