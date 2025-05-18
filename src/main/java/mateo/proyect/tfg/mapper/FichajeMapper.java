package mateo.proyect.tfg.mapper;

import mateo.proyect.tfg.models.db.FichajeDB;
import mateo.proyect.tfg.models.dto.fichaje.FichajeDetail;
import mateo.proyect.tfg.models.dto.fichaje.FichajeList;
import mateo.proyect.tfg.models.dto.fichaje.FichajeEdit;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FichajeMapper {

    FichajeMapper INSTANCE = Mappers.getMapper(FichajeMapper.class);

    FichajeDetail toFichajeDetail(FichajeDB fichajeDB);

    FichajeList toFichajeList(FichajeDB fichajeDB);

    FichajeDB toFichajeDB(FichajeEdit fichajeEdit);

    FichajeEdit toFichajeEdit(FichajeDB fichajeDB);

    void updateFichajeFromEdit(FichajeEdit fichajeEdit, @MappingTarget FichajeDB fichajeDB);
}