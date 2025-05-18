package mateo.proyect.tfg.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "clavesupersecretaJasper123456789Mateo123456789";
    private final long EXPIRATION_TIME = 360000000; 

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            String cleanToken = token.replace("Bearer ", "").replace("\"", "").trim();
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(cleanToken);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractUsername(String token) {
        try {
            String cleanToken = token.replace("Bearer ", "").replace("\"", "").trim();
            return Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(cleanToken)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}