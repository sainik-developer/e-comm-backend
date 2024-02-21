package org.example.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtService {
    public final static String JWT_CLAIM_ID = "_id";
    public final static String JWT_CLAIM_NAME = "name";
    public final static String JWT_CLAIM_EMAIL = "email";
    @Value("${jwt.key}")
    private String JWT_SIGN_KEY;
    @Value("${jwt.user.timeout.days}")
    private int JWT_USER_EXPIRATION;

    public String createToken(final Claims claims) {
        SecretKey key = Keys.hmacShaKeyFor(JWT_SIGN_KEY.getBytes());
        return Jwts.builder().signWith(key)
                .setExpiration(createTimeout())
                .setClaims(claims).compact();
    }

    /***
     * It will verify the properly signed snd unmodified as well expiration time is not yet passed.
     *
     * @param token
     * @return
     */
    public boolean isValid(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(JWT_SIGN_KEY.getBytes()).build().parseClaimsJws(token);
        } catch (JwtException e) {
            return false;
        }
        return true;
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(JWT_SIGN_KEY.getBytes()).build().parseClaimsJws(token).getBody();
    }

    public Claims userClaims(final String userId) {
        Claims claims = Jwts.claims();
        claims.put(JWT_CLAIM_ID, userId);
        claims.put(JWT_CLAIM_NAME, userId);
        claims.put(JWT_CLAIM_EMAIL, userId);
        return claims;
    }

    private Date createTimeout() {
                return DateUtils.addDays(new Date(), JWT_USER_EXPIRATION);
        }

}
