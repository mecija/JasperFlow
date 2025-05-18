package mateo.proyect.tfg.models.dto.bill;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BillList {

    private Integer id;
    private String destinatarioDenomSocial;
    private String emisorDenomSocial;
    private String fechaEmision;
    private String importeFinal;

}
