package mateo.proyect.tfg.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mateo.proyect.tfg.exception.EntityAlreadyExistsException;
import mateo.proyect.tfg.exception.EntityIllegalArgumentException;
import mateo.proyect.tfg.exception.EntityNotFoundException;
import mateo.proyect.tfg.filters.BillFilter;
import mateo.proyect.tfg.mapper.BillMapper;
import mateo.proyect.tfg.models.db.BillDB;
import mateo.proyect.tfg.models.dto.bill.BillEdit;
import mateo.proyect.tfg.repository.BillRepository;
import mateo.proyect.tfg.service.intrf.BillServiceIF;
import mateo.proyect.tfg.specification.BillSpecification;

@Service
public class BillService implements BillServiceIF {

    private final BillRepository repository;

    public BillService(BillRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<BillEdit> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(BillMapper.INSTANCE::toBillEdit);
    }

    @Override
    public Page<BillEdit> findAllWithFilters(BillFilter filter, Pageable pageable) {
        return repository.findAll(BillSpecification.filterBy(filter), pageable)
                .map(BillMapper.INSTANCE::toBillEdit);
    }

    @Override
    public BillEdit create(BillEdit obj) {
        if (obj.getId() != null) {
            throw new EntityAlreadyExistsException("Entity_Already_Exists",
                    "La entidad con id " + obj.getId() + " ya existe");
        }
        BillDB entity = BillMapper.INSTANCE.toBillDB(obj);
        return BillMapper.INSTANCE.toBillEdit(repository.save(entity));
    }

    @Override
    public BillEdit read(Integer id) {
        BillDB entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OBJECT_NOT_FOUND", "Bill not found with id: " + id));
        return BillMapper.INSTANCE.toBillEdit(entity);
    }

    @Override
    public BillEdit update(Integer id, BillEdit obj) {
        if (!id.equals(obj.getId())) {
            throw new EntityIllegalArgumentException("id_mismatch",
                    "El id proporcionado no coincide con el id del objeto a actualizar.");
        }
        BillDB existingEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OBJECT_NOT_FOUND",
                        "No se puede actualizar, el objeto con el id: " + id + " no existe."));
        BillMapper.INSTANCE.updateBillFromEdit(obj, existingEntity);
        return BillMapper.INSTANCE.toBillEdit(repository.save(existingEntity));
    }

    @Override
    public void delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}