package com.spring.security;

import com.spring.dto.UserDto;
import com.spring.models.User;
import com.spring.utils.ConstantUtil;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.Date;


@Component
public class JwtTokenUtil implements Serializable {
    private static final long serialVersionUID = -2550185165626007488L;
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);


    public String generateToken(User u, long tokenExpiry) {
        System.out.println("GENERATING TOKEN");
        Claims claims = Jwts.claims().setSubject(u.getUsername());
        claims.put("user", u.getUsername());
        claims.put("fullname", u.getFullname());
        claims.put("role", u.getRole());
        claims.put("func", u.getFunc());
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiry *1000))
                .signWith(SignatureAlgorithm.HS512, ConstantUtil.JWT_TOKEN_SECRET)
                .compact();
    }

    public UserDto parseToken(String token) {
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(ConstantUtil.JWT_TOKEN_SECRET)
                    .parseClaimsJws(token)
                    .getBody();

            UserDto u = new UserDto();
            u.setUsername(body.getSubject());
            u.setFullname((String) body.get("fullname"));
            u.setRole((String) body.get("role"));
            u.setFunc((String) body.get("func"));
            return u;

        } catch (ClassCastException e) {
            return null;
        }
        catch(JwtException e){
            return null;
        }
    }

    public Boolean validateToken(String token, String username) {
        UserDto user = parseToken(token);
        if (user == null){
            return false;
        }
        else return (
                user.getUsername().equals(username));
    }
}
