package mateo.proyect.tfg.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mateo.proyect.tfg.exception.EntityAlreadyExistsException;
import mateo.proyect.tfg.exception.EntityIllegalArgumentException;
import mateo.proyect.tfg.exception.EntityNotFoundException;
import mateo.proyect.tfg.filters.FichajeFilter;
import mateo.proyect.tfg.mapper.FichajeMapper;
import mateo.proyect.tfg.models.db.FichajeDB;
import mateo.proyect.tfg.models.dto.fichaje.FichajeEdit;
import mateo.proyect.tfg.repository.FichajeRepository;
import mateo.proyect.tfg.service.intrf.FichajeServiceIF;
import mateo.proyect.tfg.specification.FichajeSpecification;

@Service
public class FichajeService implements FichajeServiceIF {

    private final FichajeRepository repository;

    public FichajeService(FichajeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<FichajeEdit> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(FichajeMapper.INSTANCE::toFichajeEdit);
    }

    @Override
    public Page<FichajeEdit> findAllWithFilters(FichajeFilter filter, Pageable pageable) {
        return repository.findAll(FichajeSpecification.filterBy(filter), pageable)
                .map(FichajeMapper.INSTANCE::toFichajeEdit);
    }

    @Override
    public FichajeEdit create(FichajeEdit obj) {
        if (obj.getId() != null) {
            throw new EntityAlreadyExistsException("Entity_Already_Exists",
                    "La entidad con id " + obj.getId() + " ya existe");
        }
        FichajeDB entity = FichajeMapper.INSTANCE.toFichajeDB(obj);
        return FichajeMapper.INSTANCE.toFichajeEdit(repository.save(entity));
    }

    @Override
    public FichajeEdit read(Integer id) {
        FichajeDB entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OBJECT_NOT_FOUND", "Fichaje not found with id: " + id));
        return FichajeMapper.INSTANCE.toFichajeEdit(entity);
    }

    @Override
    public FichajeEdit update(Integer id, FichajeEdit obj) {
        if (!id.equals(obj.getId())) {
            throw new EntityIllegalArgumentException("id_mismatch",
                    "El id proporcionado no coincide con el id del objeto a actualizar.");
        }
        FichajeDB existingEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OBJECT_NOT_FOUND",
                        "No se puede actualizar, el objeto con el id: " + id + " no existe."));
        FichajeMapper.INSTANCE.updateFichajeFromEdit(obj, existingEntity);
        return FichajeMapper.INSTANCE.toFichajeEdit(repository.save(existingEntity));
    }

    @Override
    public void delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}