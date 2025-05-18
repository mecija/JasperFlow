package mateo.proyect.tfg.controller.client;

import mateo.proyect.tfg.filters.ClientFilter;
import mateo.proyect.tfg.models.dto.client.ClientEdit;
import mateo.proyect.tfg.service.intrf.ClientServiceIF;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientServiceIF clientService;

    public ClientController(ClientServiceIF clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<Page<ClientEdit>> getAllClients(Pageable pageable) {
        return ResponseEntity.ok(clientService.findAll(pageable));
    }

    @PostMapping("/filter")
    public ResponseEntity<Page<ClientEdit>> getClientsWithFilters(@RequestBody ClientFilter filter, Pageable pageable) {
        return ResponseEntity.ok(clientService.findAllWithFilters(filter, pageable));
    }

    @PostMapping
    public ResponseEntity<ClientEdit> createClient(@RequestBody ClientEdit clientEdit) {
        return ResponseEntity.ok(clientService.create(clientEdit));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientEdit> getClientById(@PathVariable Integer id) {
        return ResponseEntity.ok(clientService.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientEdit> updateClient(@PathVariable Integer id, @RequestBody ClientEdit clientEdit) {
        return ResponseEntity.ok(clientService.update(id, clientEdit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}