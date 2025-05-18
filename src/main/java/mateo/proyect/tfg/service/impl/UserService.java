package mateo.proyect.tfg.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mateo.proyect.tfg.exception.EntityAlreadyExistsException;
import mateo.proyect.tfg.exception.EntityIllegalArgumentException;
import mateo.proyect.tfg.exception.EntityNotFoundException;
import mateo.proyect.tfg.filters.UserFilter;
import mateo.proyect.tfg.mapper.UserMapper;
import mateo.proyect.tfg.models.db.RolDB;
import mateo.proyect.tfg.models.db.UserDB;
import mateo.proyect.tfg.models.dto.user.UserEdit;
import mateo.proyect.tfg.models.dto.user.UserRegister;
import mateo.proyect.tfg.models.dto.user.UserView;
import mateo.proyect.tfg.repository.UserRepository;
import mateo.proyect.tfg.service.intrf.UserServiceIF;
import mateo.proyect.tfg.specification.UserSpecification;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mateo.proyect.tfg.repository.RolRepository;

@Service
public class UserService implements UserServiceIF {

    private final UserRepository repository;
    private final RolRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, RolRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Page<UserView> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(UserMapper.INSTANCE::toUserView);
    }

    @Override
    public Page<UserView> findAllWithFilters(UserFilter filter, Pageable pageable) {
        return repository.findAll(UserSpecification.filterBy(filter), pageable)
                .map(UserMapper.INSTANCE::toUserView);
    }

    @Override
    public UserView create(UserRegister obj) {
        if (repository.findByEmail(obj.getEmail()).isPresent()) {
            throw new EntityAlreadyExistsException("Entity_Already_Exists",
                    "El usuario con email " + obj.getEmail() + " ya existe");
        }

        UserDB entity = UserMapper.INSTANCE.toUserDBFromRegister(obj);

        RolDB userRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new EntityNotFoundException("ROLE_NOT_FOUND", "El rol 'USER' no existe"));
        entity.setRoles(Set.of(userRole));

        entity.setPassword(passwordEncoder.encode(obj.getPassword()));

        return UserMapper.INSTANCE.toUserView(repository.save(entity));
    }

    @Override
    public UserView read(Integer id) {
        UserDB entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OBJECT_NOT_FOUND", "User not found with id: " + id));
        return UserMapper.INSTANCE.toUserView(entity);
    }

    @Override
    public UserView update(Integer id, UserEdit obj) {
        if (!id.equals(obj.getId())) {
            throw new EntityIllegalArgumentException("id_mismatch",
                    "El id proporcionado no coincide con el id del objeto a actualizar.");
        }
        UserDB existingEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OBJECT_NOT_FOUND",
                        "No se puede actualizar, el objeto con el id: " + id + " no existe."));
        UserMapper.INSTANCE.updateUserFromEdit(obj, existingEntity);
        return UserMapper.INSTANCE.toUserView(repository.save(existingEntity));
    }

    @Override
    public void delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("OBJECT_NOT_FOUND",
                    "No se puede eliminar, el objeto con el id: " + id + " no existe.");
        }
    }

    @Override
    public boolean validateCredentials(String email, String password) {
        return repository.findByEmail(email)
                .map(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElse(false);
    }

    @Override
    public UserView findUserViewByEmail(String email) {
        return repository.findByEmail(email)
                .map(UserMapper.INSTANCE::toUserView)
                .orElseThrow(() -> new EntityNotFoundException("OBJECT_NOT_FOUND", "User not found with email: " + email));
    }
}