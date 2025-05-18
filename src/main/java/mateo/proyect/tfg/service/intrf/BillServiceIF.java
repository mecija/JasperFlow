package mateo.proyect.tfg.service.intrf;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mateo.proyect.tfg.models.dto.bill.BillEdit;
import mateo.proyect.tfg.filters.BillFilter;

public interface BillServiceIF {

    public BillEdit create(BillEdit obj);
    public BillEdit read(Integer id);
    public BillEdit update(Integer id, BillEdit obj);
    public void delete(Integer id);
    Page<BillEdit> findAll(Pageable pageable);
    Page<BillEdit> findAllWithFilters(BillFilter filter, Pageable pageable);

}