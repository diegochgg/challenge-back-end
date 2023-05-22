package com.pichincha.challengebackend.authentication.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JwtProvider {

    private final String SECRET_KEY = "secretKey";

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 3600000);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public String getTokenFromHeader(HttpServletRequest httpServletRequest) {
        String token = null;
        String header = httpServletRequest.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer")) {
            token = header.replace("Bearer ", "");
        }
        return token;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException malformedJwtException) {
            log.error("The JWT token is malformed, Value: {}", token);
        } catch (UnsupportedJwtException unsupportedJwtException) {
            log.error("The JWT token is unsupported, Value: {}", token);
        } catch (ExpiredJwtException expiredJwtException) {
            log.error("The JWT token is expired, Value: {}", token);
        } catch (IllegalArgumentException illegalArgumentException) {
            log.error("The JWT Token is empty");
        } catch (SignatureException signatureException) {
            log.error("The JWT Token Signature is at failure, Value: {}", token);
        }
        return false;
    }

}
