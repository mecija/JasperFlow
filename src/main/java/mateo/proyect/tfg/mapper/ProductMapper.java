package mateo.proyect.tfg.mapper;

import mateo.proyect.tfg.models.db.ProductDB;
import mateo.proyect.tfg.models.dto.product.ProductDetail;
import mateo.proyect.tfg.models.dto.product.ProductList;
import mateo.proyect.tfg.models.dto.product.ProductEdit;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDetail toProductDetail(ProductDB productDB);
    ProductList toProductList(ProductDB productDB);
    ProductDB toProductDB(ProductEdit productEdit);
    ProductEdit toProductEdit(ProductDB productDB);
    void updateProductFromEdit(ProductEdit productEdit, @MappingTarget ProductDB productDB);

}