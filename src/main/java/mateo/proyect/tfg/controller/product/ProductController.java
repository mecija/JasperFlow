package mateo.proyect.tfg.controller.product;

import mateo.proyect.tfg.filters.ProductFilter;
import mateo.proyect.tfg.models.dto.product.ProductEdit;
import mateo.proyect.tfg.service.intrf.ProductServiceIF;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductServiceIF productService;

    public ProductController(ProductServiceIF productService) {
        this.productService = productService;
    }

    @PostMapping("/filter")
    public ResponseEntity<Page<ProductEdit>> getProductsWithFilters(@RequestBody ProductFilter filter,
            Pageable pageable) {
        return ResponseEntity.ok(productService.findAllWithFilters(filter, pageable));
    }

    @GetMapping
    public ResponseEntity<Page<ProductEdit>> getAllProducts(Pageable pageable) {
        return ResponseEntity.ok(productService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<ProductEdit> createProduct(@RequestBody ProductEdit productEdit) {
        return ResponseEntity.ok(productService.create(productEdit));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEdit> getProductById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEdit> updateProduct(@PathVariable Integer id, @RequestBody ProductEdit productEdit) {
        return ResponseEntity.ok(productService.update(id, productEdit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}