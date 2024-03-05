package com.txtalk.chat.controller.user;

import com.txtalk.chat.model.user.UserModel;
import com.txtalk.chat.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/get-all-users")
    public List<UserModel> getAllUsers(){
        return userRepository.findAllUsers();
    }
}
