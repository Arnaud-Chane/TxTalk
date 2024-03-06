package com.txtalk.chat.model.message;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedNativeQuery(name = "MessageModel.findMessageDTOByNickname",
                  query = "SELECT m.message_id,\n" +
                          "m.message_content,\n" +
                          "m.created_at,\n" +
                          "c.chat_name,\n" +
                          "u.nickname\n" +
                          "FROM txtalk_db.message m\n" +
                          "JOIN txtalk_db.user u ON m.user_id = u.user_id\n" +
                          "JOIN txtalk_db.chat c ON m.chat_id = c.chat_id\n" +
                          "WHERE u.nickname = ?1",
                  resultSetMapping = "Mapping.MessageDTO")

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
}
