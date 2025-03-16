package com.app.sony.config;

import com.app.sony.Service.JWTService;
import com.app.sony.Service.UserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    JWTService jwtService;

    @Autowired
    ApplicationContext applicationContext;
    String email = null;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String path = request.getServletPath();
        // Skip filter for login and register endpoints
        if (path.equals("/login") || path.equals("/register") || path.equals("/products") || path.equals("/categories")) {
            filterChain.doFilter(request, response);
            return;
        }

        System.out.println("ssssssssssssss");
        System.out.println(request);
        System.out.println(request.getHeader("Authorization"));
        String authHeader = request.getHeader("Authorization");
        String token = null;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            email = jwtService.extractEmail(token);
            // Validate the token and extract user information
            // Set the user information in the request for further processing
        }

        if(email != null && SecurityContextHolder.getContext().getAuthentication() == null)
        {
            UserDetails userDetails =  applicationContext.getBean(UserDetailsService.class).loadUserByUsername(email);
            if(jwtService.validateToken(token,userDetails)){
                UsernamePasswordAuthenticationToken  usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
