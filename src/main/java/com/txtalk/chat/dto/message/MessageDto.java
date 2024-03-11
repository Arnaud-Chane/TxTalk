package com.txtalk.chat.dto.message;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDto {

    private String message_content;
    private Integer user_id;
    private Integer chat_id;
    private String created_at;

    public MessageDto() {}

    public MessageDto(String message_content, Integer user_id, Integer chat_id, String created_at) {
        this.message_content = message_content;
        this.user_id = user_id;
        this.chat_id = chat_id;
        this.created_at = created_at;
    }

    public String getMessage_content() {
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getChat_id() {
        return chat_id;
    }

    public void setChat_id(Integer chat_id) {
        this.chat_id = chat_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
