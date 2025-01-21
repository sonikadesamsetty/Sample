/*
package com.app.sony.Controller;


import com.app.sony.Service.UserService;
import com.app.sony.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final UserService userService;

    @Autowired
    public AuthController( JwtUtil jwtTokenUtil, UserService userService) {
        //this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtTokenUtil;
        this.userService = userService;
    }

    //@PostMapping("/login")
    public String login(@RequestBody User user) {
        System.out.println(user);
        if ("user".equals(user.getEmail()) && "password".equals(user.getPassword())) {
            // Generate a JWT token
            return jwtUtil.generateToken(user.getEmail());
        }
        return "Invalid credentials";
    }
}*/
