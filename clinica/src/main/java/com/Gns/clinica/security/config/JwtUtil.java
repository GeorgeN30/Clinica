package com.Gns.clinica.security.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {
    private final static String JWT_SECRET = "adminGeorge123";
    private final static Algorithm ALGORITHM = Algorithm.HMAC256(JWT_SECRET);


    private static final long ACCESS_TOKEN_EXPIRATION = TimeUnit.MINUTES.toMillis(15);
    private static final long REFRESH_TOKEN_EXPIRATION = TimeUnit.DAYS.toMillis(7);

    public String generateAccessToken(String email){
        return JWT.create()
                .withSubject(email)
                .withIssuer("george-clinica-utp")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRATION))
                .sign(ALGORITHM);
    }
    public String generateRefreshToken(String email) {
        return JWT.create()
                .withSubject(email)
                .withIssuer("george-clinica-utp")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRATION))
                .sign(ALGORITHM);
    }

    public String getUsername(String token) {
        return JWT.require(ALGORITHM)
                .build()
                .verify(token)
                .getSubject();
    }

    public boolean verifyJwt(String jwt){
        try{
            JWT.require(ALGORITHM)
                    .build()
                    .verify(jwt);
            return true;
        }catch(JWTVerificationException e){
            return false;
        }
    }
}
