package com.txtalk.chat.model.repository.message;

import com.txtalk.chat.model.entity.message.MessageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<MessageModel, Integer> {

    @Query(value = "SELECT m.message_id,\n" +
            "  m.message_content,\n" +
            "  m.created_at,\n" +
            "  c.chat_name,\n" +
            "  u.nickname\n" +
            "FROM txtalk_db.message m\n" +
            "  JOIN txtalk_db.user u ON m.user_id = u.user_id\n" +
            "  JOIN txtalk_db.chat c ON m.chat_id = c.chat_id\n" +
            "WHERE u.nickname = ?1", nativeQuery = true)
    List<MessageModel> findMessagesByUser(String nickname);

    @Query(value = "SELECT m.message_id,\n" +
            "  m.message_content,\n" +
            "  m.created_at,\n" +
            "  u.nickname\n" +
            "FROM txtalk_db.message m\n" +
            "  JOIN txtalk_db.user u ON m.user_id = u.user_id\n" +
            "  JOIN txtalk_db.chat c ON m.chat_id = c.chat_id\n" +
            "WHERE c.chat_name = ?1", nativeQuery = true)
    List<MessageModel> findMessagesByChat(String chatName);

    @Query(value = "SELECT * FROM message WHERE user_id = ?1", nativeQuery = true)
    List<MessageModel> findMessageByUserId(Integer id);

}
