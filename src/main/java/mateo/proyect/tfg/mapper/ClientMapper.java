package mateo.proyect.tfg.mapper;

import mateo.proyect.tfg.models.db.ClientDB;
import mateo.proyect.tfg.models.dto.client.ClientDetail;
import mateo.proyect.tfg.models.dto.client.ClientList;
import mateo.proyect.tfg.models.dto.client.ClientEdit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDetail toClientDetail(ClientDB clientDB);
    ClientList toClientList(ClientDB clientDB);
    ClientDB toClientDB(ClientEdit clientEdit);
    ClientEdit toClientEdit(ClientDB clientDB);
    void updateClientFromEdit(ClientEdit clientEdit, @MappingTarget ClientDB clientDB);
}
