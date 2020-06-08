package com.spring.security;

import com.spring.dto.UserDto;
import com.spring.utils.CommonUtil;
import com.spring.utils.ConstantUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(ConstantUtil.JWT_HEADER_STRING);
        System.out.println("INSIDE JwtAuthenticationFilter");

        String authToken = null;
        UserDto user = null;
        if (header != null && header.startsWith(ConstantUtil.JWT_TOKEN_PREFIX)) {
            authToken = header.replace(ConstantUtil.JWT_TOKEN_PREFIX,"");
            try {
                user = jwtTokenUtil.parseToken(authToken);
            } catch (IllegalArgumentException e) {
                logger.error("an error occured during getting username from token", e);
            } catch (ExpiredJwtException e) {
                logger.warn("the token is expired and not valid anymore", e);
            }catch(SignatureException e){
                logger.error("Authentication Failed. Username or Password not valid.");
            }
        } else {
            logger.warn("couldn't find bearer string, will ignore the header");
        }

        if (user != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (jwtTokenUtil.validateToken(authToken, user.getUsername())) {
                System.out.println("Token is Valid");
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), null, CommonUtil.getAuthority(user.getRole()));
                authentication.setDetails(user);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(req, res);
    }
}
