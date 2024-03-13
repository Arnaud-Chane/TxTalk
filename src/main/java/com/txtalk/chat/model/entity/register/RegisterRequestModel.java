package com.txtalk.chat.model.entity.register;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestModel {

    private String firstname;
    private String lastname;
    private String nickname;
    private String email;
    private String password;
}
