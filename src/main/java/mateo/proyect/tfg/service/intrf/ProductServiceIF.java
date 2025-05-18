package mateo.proyect.tfg.service.intrf;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mateo.proyect.tfg.filters.ProductFilter;
import mateo.proyect.tfg.models.db.ProductDB;
import mateo.proyect.tfg.models.dto.product.ProductEdit;

public interface ProductServiceIF {

    public ProductEdit create(ProductEdit obj);

    public ProductEdit read(Integer id);

    public ProductEdit update(Integer id, ProductEdit obj);

    public void delete(Integer id);

    Page<ProductEdit> findAll(Pageable pageable);

    Page<ProductEdit> findAllWithFilters(ProductFilter filter, Pageable pageable);
}