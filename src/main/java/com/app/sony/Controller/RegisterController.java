package com.app.sony.Controller;

import com.app.sony.Service.UserService;
import com.app.sony.api.RegisterApi;
import com.app.sony.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class RegisterController implements RegisterApi {

    @Autowired
    UserService registerService;
    @Override
    public ResponseEntity<User> registerPost(User user) {
        return ResponseEntity.ok(registerService.registerUser(user));
    }
}
