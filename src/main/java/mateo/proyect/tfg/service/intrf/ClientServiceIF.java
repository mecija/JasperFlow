package mateo.proyect.tfg.service.intrf;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mateo.proyect.tfg.filters.ClientFilter;
import mateo.proyect.tfg.models.db.ClientDB;
import mateo.proyect.tfg.models.dto.client.ClientEdit;

public interface ClientServiceIF {


    public ClientEdit create(ClientEdit obj);
    public ClientEdit read(Integer id);
    public ClientEdit update(Integer id, ClientEdit obj);
    public void delete(Integer id);
    Page<ClientEdit> findAll(Pageable pageable);
    Page<ClientEdit> findAllWithFilters(ClientFilter filter, Pageable pageable);

}
