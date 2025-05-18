package mateo.proyect.tfg.controller.bill;

import mateo.proyect.tfg.filters.BillFilter;
import mateo.proyect.tfg.models.dto.bill.BillEdit;
import mateo.proyect.tfg.models.dto.order.OrderEdit;
import mateo.proyect.tfg.service.intrf.BillServiceIF;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    private final BillServiceIF billService;

    public BillController(BillServiceIF billService) {
        this.billService = billService;
    }

    @GetMapping
    public ResponseEntity<Page<BillEdit>> getAllOrders(Pageable pageable) {
        return ResponseEntity.ok(billService.findAll(pageable));
    }

    @PostMapping("/filter")
    public ResponseEntity<Page<BillEdit>> getBillsWithFilters(@RequestBody BillFilter filter, Pageable pageable) {
        return ResponseEntity.ok(billService.findAllWithFilters(filter, pageable));
    }

    @PostMapping
    public ResponseEntity<BillEdit> createBill(@RequestBody BillEdit billEdit) {
        BillEdit createdBill = billService.create(billEdit);
        return ResponseEntity.ok(createdBill);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillEdit> getBillById(@PathVariable Integer id) {
        BillEdit bill = billService.read(id);
        return ResponseEntity.ok(bill);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillEdit> updateBill(@PathVariable Integer id, @RequestBody BillEdit billEdit) {
        BillEdit updatedBill = billService.update(id, billEdit);
        return ResponseEntity.ok(updatedBill);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable Integer id) {
        billService.delete(id);
        return ResponseEntity.noContent().build();
    }
}