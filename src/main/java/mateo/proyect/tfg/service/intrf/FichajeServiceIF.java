package mateo.proyect.tfg.service.intrf;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mateo.proyect.tfg.filters.FichajeFilter;
import mateo.proyect.tfg.models.db.FichajeDB;
import mateo.proyect.tfg.models.dto.fichaje.FichajeEdit;

public interface FichajeServiceIF {

    public FichajeEdit create(FichajeEdit obj);
    public FichajeEdit read(Integer id);
    public FichajeEdit update(Integer id, FichajeEdit obj);
    public void delete(Integer id);
    Page<FichajeEdit> findAll(Pageable pageable);
    Page<FichajeEdit> findAllWithFilters(FichajeFilter filter, Pageable pageable);
}