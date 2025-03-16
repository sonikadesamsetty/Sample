package com.app.sony.Service;

import com.app.sony.entity.UserEntity;
import com.app.sony.model.Response;
import com.app.sony.model.User;
import com.app.sony.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    AuthenticationManager  authenticationManager;

    @Autowired
    JWTService jwtService;

    @Autowired
    UserRepo userRepo;

    public Response verify(User user) {

        Authentication  authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
        System.out.println("sonika");
        System.out.println(authentication.isAuthenticated());
        if(authentication.isAuthenticated())
        {
            String token = jwtService.generateToken(user.getEmail());
            System.out.println(token);
            return new Response(token, user);
        }
        return new Response(null,null);
    }

    public User register(User user) {
        UserEntity  userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setRole(user.getRole());
        userEntity.setAddress(user.getAddress());
        userEntity.setMobileNumber(user.getMobileNumber());
        userRepo.save(userEntity);
        return user;
    }
}
