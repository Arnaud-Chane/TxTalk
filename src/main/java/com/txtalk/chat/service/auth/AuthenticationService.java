package com.txtalk.chat.service.auth;

import com.txtalk.chat.model.auth.AuthenticationRequestModel;
import com.txtalk.chat.model.auth.AuthenticationResponseModel;
import com.txtalk.chat.model.register.RegisterRequestModel;
import com.txtalk.chat.model.user.Role;
import com.txtalk.chat.model.user.UserModel;
import com.txtalk.chat.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponseModel register(RegisterRequestModel request) {
        var user = UserModel.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .nickname(request.getNickname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseModel.builder()
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponseModel authenticate(AuthenticationRequestModel request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseModel.builder()
                .token(jwtToken)
                .build();
    }
}


