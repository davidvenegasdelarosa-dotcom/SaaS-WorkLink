package com.example.demo.service;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //Para que se cree automáticamente
public class JwtService {

    @Value("${worklink.jwt.secret}")
    private String secret;

    public String generateToken(String correo){
        Key key = Keys.hmacShaKeyFor(secret.getBytes());
        return Jwts.builder()
            .setSubject(correo)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 3600000)) //Tiempo de expiracion=hora actual + cte
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
    }
}
