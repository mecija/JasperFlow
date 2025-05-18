package mateo.proyect.tfg.controller.auth;

import mateo.proyect.tfg.models.dto.auth.LoginResponse;
import mateo.proyect.tfg.models.dto.user.UserLogin;
import mateo.proyect.tfg.models.dto.user.UserView;
import mateo.proyect.tfg.security.JwtUtil;
import mateo.proyect.tfg.service.intrf.UserServiceIF;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import mateo.proyect.tfg.models.dto.auth.TokenRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserServiceIF userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserServiceIF userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLogin userLogin) {
        if (userService.validateCredentials(userLogin.getEmail(), userLogin.getPassword())) {
            UserView userView = userService.findUserViewByEmail(userLogin.getEmail());
            if (userView == null || !userView.isEnabled()) {
                return ResponseEntity.status(403).body("Usuario deshabilitado");
            }
            String token = jwtUtil.generateToken(userLogin.getEmail());
            LoginResponse response = new LoginResponse("Bearer " + token, userView);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyToken(@RequestBody TokenRequest tokenRequest) {
        try {
            String cleanToken = tokenRequest.getToken().replace("Bearer ", "").trim();
            String email = jwtUtil.extractUsername(cleanToken);

            if (email != null && jwtUtil.validateToken(cleanToken)) {
                UserView userView = userService.findUserViewByEmail(email);
                if (userView == null || !userView.isEnabled()) {
                    return ResponseEntity.status(403).body("Usuario deshabilitado");
                }
                LoginResponse response = new LoginResponse("Bearer " + cleanToken, userView);
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(401).body("Token inválido");
            }
        } catch (Exception e) {
            System.out.println("Error al verificar el token: " + e.getMessage());
            return ResponseEntity.status(401).body("Token inválido");
        }
    }
}