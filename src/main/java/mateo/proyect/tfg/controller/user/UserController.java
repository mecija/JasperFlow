package mateo.proyect.tfg.controller.user;

import mateo.proyect.tfg.filters.UserFilter;
import mateo.proyect.tfg.models.dto.user.UserEdit;
import mateo.proyect.tfg.service.intrf.UserServiceIF;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import mateo.proyect.tfg.models.dto.user.UserLogin;
import mateo.proyect.tfg.models.dto.user.UserRegister;
import mateo.proyect.tfg.models.dto.user.UserView;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceIF userService;

    public UserController(UserServiceIF userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Page<UserView>> getAllUsers(Pageable pageable) {
        return ResponseEntity.ok(userService.findAll(pageable));
    }

    @PostMapping("/filter")
    public ResponseEntity<Page<UserView>> getUsersWithFilters(@RequestBody UserFilter filter, Pageable pageable) {
        return ResponseEntity.ok(userService.findAllWithFilters(filter, pageable));
    }

    @PostMapping("/create")
    public ResponseEntity<UserView> createUser(@RequestBody UserRegister userRegister) {
        UserView createdUser = userService.create(userRegister);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserView> getUserById(@PathVariable Integer id) {
        UserView user = userService.read(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserView> updateUser(@PathVariable Integer id, @RequestBody UserEdit userEdit) {
        UserView updatedUser = userService.update(id, userEdit);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}