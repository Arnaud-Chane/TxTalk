package com.txtalk.chat.model.entity.message;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "message")
public class MessageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer message_id;

    private String message_content;
    private Integer user_id;
    private Integer chat_id;
    private String created_at;

    public MessageModel(String message_content) {
        this.message_content = message_content;
    }
}
