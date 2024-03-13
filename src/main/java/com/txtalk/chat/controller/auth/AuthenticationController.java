package com.txtalk.chat.controller.auth;

import com.txtalk.chat.model.entity.auth.AuthenticationRequestModel;
import com.txtalk.chat.model.entity.auth.AuthenticationResponseModel;
import com.txtalk.chat.model.entity.register.RegisterRequestModel;
import com.txtalk.chat.service.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseModel> register(
            @RequestBody RegisterRequestModel request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseModel> authenticate(
            @RequestBody AuthenticationRequestModel request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}

