package mateo.proyect.tfg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mateo.proyect.tfg.exception.EntityAlreadyExistsException;
import mateo.proyect.tfg.exception.EntityIllegalArgumentException;
import mateo.proyect.tfg.exception.EntityNotFoundException;
import mateo.proyect.tfg.filters.ClientFilter;
import mateo.proyect.tfg.mapper.ClientMapper;
import mateo.proyect.tfg.models.db.ClientDB;
import mateo.proyect.tfg.models.dto.client.ClientEdit;
import mateo.proyect.tfg.repository.ClientRepository;
import mateo.proyect.tfg.service.intrf.ClientServiceIF;
import mateo.proyect.tfg.specification.ClientSpecification;

@Service

public class ClientService implements ClientServiceIF {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<ClientEdit> findAllWithFilters(ClientFilter filter, Pageable pageable) {
        return repository.findAll(ClientSpecification.filterBy(filter), pageable)
                .map(ClientMapper.INSTANCE::toClientEdit);
    }

    @Override
    public Page<ClientEdit> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(ClientMapper.INSTANCE::toClientEdit);
    }

    @Override
    public ClientEdit create(ClientEdit obj) {
        if (obj.getId() != null) {
            throw new EntityAlreadyExistsException("Entity_Already_Exists",
                    "La entidad con id" + obj.getId() + " ya existe");
        }
        ClientDB entity = ClientMapper.INSTANCE.toClientDB(obj);
        return ClientMapper.INSTANCE.toClientEdit(repository.save(entity));
    }

    @Override
    public ClientEdit read(Integer id) {
        ClientDB entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OBJECT_NOT_FOUND", "Client not found with id: " + id));
        return ClientMapper.INSTANCE.toClientEdit(entity);

    }

    @Override
    public ClientEdit update(Integer id, ClientEdit obj) {
        if (!id.equals(obj.getId())) {
            throw new EntityIllegalArgumentException("id_mismatch",
                    "El id proporcionado no coincide con el id del objeto a actualizar.");

        }
        ClientDB existingEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OBJECT_NOT_FOUND",
                        "No se puede actualizar, el objeto con el id:" + id + " no existe."));

        ClientMapper.INSTANCE.updateClientFromEdit(obj, existingEntity);
        return ClientMapper.INSTANCE.toClientEdit(repository.save(existingEntity));

    }

    @Override
    public void delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

}
