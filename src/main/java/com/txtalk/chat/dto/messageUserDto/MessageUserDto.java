package com.txtalk.chat.dto.messageUserDto;

import lombok.Builder;
import lombok.Data;

@Data
public class MessageUserDto {
    private String user_nickname;
    private String msg_message_content;

    public MessageUserDto(String nickname, String message_content){
        this.user_nickname = nickname;
        this.msg_message_content = message_content;
    }
}
