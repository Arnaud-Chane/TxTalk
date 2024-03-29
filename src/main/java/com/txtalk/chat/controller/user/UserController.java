package com.txtalk.chat.controller.user;

import com.txtalk.chat.model.user.UserModel;
import com.txtalk.chat.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public List<UserModel> getAllUsers(){
        return userRepository.findAllUsers();
    }

    @GetMapping("/all/count")
    public Integer getNumberOfAllUsers(){
        return userRepository.countAllUsers();
    }

    @PostMapping("/email")
    public UserModel getUserByEmail(@RequestBody Map<String, String> body){
        return (UserModel) userRepository.findUserByEmail(body.get("email"));
    }

    @PostMapping("/nickname")
    public UserModel getUserByNickname(@RequestBody Map<String, String> body) {
        return (UserModel) userRepository.findUserByNickname(body.get("nickname"));
    }
}
