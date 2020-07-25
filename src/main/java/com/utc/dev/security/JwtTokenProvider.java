package com.utc.dev.security;

import com.utc.dev.model.CustomUserDetail;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {

    static final long EXPIRATION_TIME = 604800000L;

    private static final String SECRET = "A4343434343434343";

    public String generateToken(CustomUserDetail userDetail) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
        return Jwts.builder()
                .setSubject(userDetail.getUser().get_id())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    public String getUserFromJWT(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            System.out.println(Jwts.parser().setSigningKey(SECRET).parseClaimsJws(authToken));
            return true;
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            log.error("ERROR: ", e);
        }
        return false;
    }
}
