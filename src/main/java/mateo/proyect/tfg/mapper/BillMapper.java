package mateo.proyect.tfg.mapper;

import mateo.proyect.tfg.models.db.BillDB;
import mateo.proyect.tfg.models.dto.bill.BillDetail;
import mateo.proyect.tfg.models.dto.bill.BillList;
import mateo.proyect.tfg.models.dto.bill.BillEdit;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BillMapper {

    BillMapper INSTANCE = Mappers.getMapper(BillMapper.class);

    BillDetail toBillDetail(BillDB billDB);

    BillList toBillList(BillDB billDB);

    BillDB toBillDB(BillEdit billEdit);

    BillEdit toBillEdit(BillDB billDB);

    void updateBillFromEdit(BillEdit billEdit, @MappingTarget BillDB billDB);
}