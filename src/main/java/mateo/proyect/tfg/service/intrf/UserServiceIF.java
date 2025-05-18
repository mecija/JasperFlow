package mateo.proyect.tfg.service.intrf;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mateo.proyect.tfg.filters.UserFilter;
import mateo.proyect.tfg.models.dto.user.UserEdit;
import mateo.proyect.tfg.models.dto.user.UserRegister;
import mateo.proyect.tfg.models.dto.user.UserView;

public interface UserServiceIF {

    public UserView create(UserRegister obj);

    public UserView read(Integer id);

    public UserView update(Integer id, UserEdit obj);

    public void delete(Integer id);

    public boolean validateCredentials(String email, String password);
    public UserView findUserViewByEmail(String email);

    Page<UserView> findAll(Pageable pageable);

    public Page<UserView> findAllWithFilters(UserFilter filter, Pageable pageable);
}