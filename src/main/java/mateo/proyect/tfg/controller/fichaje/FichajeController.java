package mateo.proyect.tfg.controller.fichaje;

import mateo.proyect.tfg.filters.FichajeFilter;
import mateo.proyect.tfg.models.dto.fichaje.FichajeEdit;
import mateo.proyect.tfg.models.dto.order.OrderEdit;
import mateo.proyect.tfg.service.intrf.FichajeServiceIF;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fichajes")
public class FichajeController {

    private final FichajeServiceIF fichajeService;

    public FichajeController(FichajeServiceIF fichajeService) {
        this.fichajeService = fichajeService;
    }

    @PostMapping("/filter")
    public ResponseEntity<Page<FichajeEdit>> getFichajesWithFilters(@RequestBody FichajeFilter filter,
            Pageable pageable) {
        return ResponseEntity.ok(fichajeService.findAllWithFilters(filter, pageable));
    }

    @GetMapping
    public ResponseEntity<Page<FichajeEdit>> getAllFichajes(Pageable pageable) {
        return ResponseEntity.ok(fichajeService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<FichajeEdit> createFichaje(@RequestBody FichajeEdit fichajeEdit) {
        return ResponseEntity.ok(fichajeService.create(fichajeEdit));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FichajeEdit> getFichajeById(@PathVariable Integer id) {
        return ResponseEntity.ok(fichajeService.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FichajeEdit> updateFichaje(@PathVariable Integer id, @RequestBody FichajeEdit fichajeEdit) {
        return ResponseEntity.ok(fichajeService.update(id, fichajeEdit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFichaje(@PathVariable Integer id) {
        fichajeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}