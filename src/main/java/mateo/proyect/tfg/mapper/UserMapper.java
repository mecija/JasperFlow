package mateo.proyect.tfg.mapper;

import mateo.proyect.tfg.models.db.UserDB;
import mateo.proyect.tfg.models.dto.role.RoleDTO;
import mateo.proyect.tfg.models.dto.user.UserDetail;
import mateo.proyect.tfg.models.dto.user.UserList;
import mateo.proyect.tfg.models.dto.user.UserEdit;
import mateo.proyect.tfg.models.dto.user.UserRegister;
import mateo.proyect.tfg.models.dto.user.UserView;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import mateo.proyect.tfg.models.dto.user.UserLogin;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDetail toUserDetail(UserDB userDB);

    UserList toUserList(UserDB userDB);

    UserDB toUserDB(UserEdit userEdit);

    UserEdit toUserEdit(UserDB userDB);

    UserLogin toUserLogin(UserDB userDB);

    UserDB toUserDBFromRegister(UserRegister userRegister);

    UserView toUserView(UserDB userDB);

    RoleDTO toRoleDTO(mateo.proyect.tfg.models.db.RolDB rolDB);

    void updateUserFromEdit(UserEdit userEdit, @MappingTarget UserDB userDB);
}