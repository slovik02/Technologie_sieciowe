package ib.ts_2.services;

import ib.ts_2.CommonTypes.UserRole;
import ib.ts_2.entity.Auth;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    /*
      Service class responsible for JWT token generation and validation.
     */

    private long tokenLifetime = 1000 * 60 * 24;  //24 minutes

    @Value("${token.signingkey}")

    private String jwtSigningKey;
    public String generateToken(Auth userDetail){
        /*
          Generates a JWT token for the given user details.
          @param userDetail The user details.
          @return The generated JWT token.
         */
        return generateToken(new HashMap<>(), userDetail);
    }

    public UserRole extractRole(String token){
        /*
          Extracts the role from the JWT token.
          @param token The JWT token.
          @return The user role extracted from the token.
         */
        String roleString = extractClaim(token, (claims) -> claims.get("role", String.class));
        return UserRole.valueOf(roleString);
    }

    public boolean isTokenValid(String token){
        /*
          Checks if the JWT token is valid.
          @param token The JWT token.
          @return true if the token is valid, false otherwise.
         */
        try{
            return !isTokenExpired(token);
        } catch (Exception e){
            return false;
        }
    }

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload();
    }

    private String generateToken(Map<String,Object> extraClaims, Auth userDetails){
        extraClaims.put("role", userDetails.getRole());
        return Jwts.builder()
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + tokenLifetime))
                .signWith(getSigningKey())
                .compact();
    }

    private SecretKey getSigningKey() {

        byte[] keyBytes = Decoders.BASE64.decode(jwtSigningKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
