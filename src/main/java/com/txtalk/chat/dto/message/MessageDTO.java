package com.txtalk.chat.dto.message;

import lombok.Data;
import lombok.Getter;

import java.sql.Timestamp;

@Data
public class MessageDTO {

    private Integer messageId;
    private String messageContent;
    private Timestamp createAt;
    private String chatName;
    private String nickname;

}
