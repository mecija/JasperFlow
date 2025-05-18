package mateo.proyect.tfg.controller.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mateo.proyect.tfg.filters.OrderFilter;
import mateo.proyect.tfg.models.dto.order.OrderEdit;
import mateo.proyect.tfg.service.intrf.OrderServiceIF;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderServiceIF orderService;

    public OrderController(OrderServiceIF orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderEdit> createOrder(@RequestBody OrderEdit orderEdit) {
        return ResponseEntity.ok(orderService.create(orderEdit));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderEdit> getOrderById(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderEdit> updateOrder(@PathVariable Integer id, @RequestBody OrderEdit orderEdit) {
        return ResponseEntity.ok(orderService.update(id, orderEdit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<OrderEdit>> getAllOrders(Pageable pageable) {
        return ResponseEntity.ok(orderService.findAll(pageable));
    }

     @PostMapping("/filter")
    public ResponseEntity<Page<OrderEdit>> getOrdersWithFilters(@RequestBody OrderFilter filter, Pageable pageable) {
        return ResponseEntity.ok(orderService.findAllWithFilters(filter, pageable));
    }
}