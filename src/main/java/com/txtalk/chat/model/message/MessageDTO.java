package com.txtalk.chat.model.message;

import java.sql.Timestamp;

public class MessageDTO {

    private Integer messageId;
    private String messageContent;
    private Timestamp createAt;
    private String chatName;
    private String nickname;

    public Integer getMessageId() {
        return messageId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public String getChatName() {
        return chatName;
    }

    public String getNickname() {
        return nickname;
    }
}
