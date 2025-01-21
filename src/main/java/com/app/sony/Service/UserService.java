package com.app.sony.Service;

import com.app.sony.entity.UserEntity;
import com.app.sony.model.User;
import com.app.sony.repository.UserRepository;
import com.app.sony.util.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User registerUser(User user) {

        System.out.println("Register Service");
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setAddress(user.getAddress());
        userEntity.setMobileNumber(user.getMobileNumber());
        userEntity.setRole(RoleEnum.valueOf(user.getRole().name()));
        userEntity =  userRepository.save(userEntity);
        user.setUserId(userEntity.getUserId());
        return user;

    }

    public User loginUser(User user) {
        Optional<UserEntity> userEntity = userRepository.findByEmail(user.getEmail());
        if(userEntity.isPresent() && userEntity.get().getPassword().equals(user.getPassword())){
            user.setName(userEntity.get().getName());
            user.setEmail(userEntity.get().getEmail());
            user.setAddress(userEntity.get().getAddress());
            user.setMobileNumber(userEntity.get().getMobileNumber());
            user.setRole(User.RoleEnum.valueOf(userEntity.get().getRole().name()));
            return user;
        }
        return null;
    }
}
