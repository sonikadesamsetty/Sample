package com.app.sony.Controller;

import com.app.sony.Service.UserService;
import com.app.sony.api.LoginApi;
import com.app.sony.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class LoginController implements LoginApi {

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<User> loginPost(User user) {
        System.out.println("S");
        User user1 = userService.loginUser(user);
        System.out.println(user1);
        if(user1 != null){
            return ResponseEntity.ok(user1);
        }
        return null;
    }
}
