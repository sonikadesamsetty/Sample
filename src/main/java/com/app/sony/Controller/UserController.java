package com.app.sony.Controller;

import com.app.sony.entity.UserEntity;
import com.app.sony.model.Response;
import com.app.sony.model.User;
import com.app.sony.repository.UserRepo;
import com.app.sony.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")public class UserController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", produces = {"application/json"}, method = RequestMethod.POST)
    public Response loginUser(@RequestBody User user) {
        System.out.println("33333333333");
        System.out.println(user);
        Response resp = userService.verify(user);
        System.out.println(resp);
        return resp;
    }
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        System.out.println(user);
        User resp = userService.register(user);
         return ResponseEntity.ok(resp);
    }
}
