package com.txtalk.chat.repository.chat;

import com.txtalk.chat.model.chat.ChatModel;
import com.txtalk.chat.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatRepository extends JpaRepository<ChatModel, Integer> {

    @Query(value = "SELECT * FROM chat", nativeQuery = true)
    List<ChatModel> findAllChats();

    @Query(value = "SELECT c.chat_id,\n" +
            "c.chat_name\n" +
            "FROM txtalk_db.chat c\n" +
            "WHERE chat_name = ?1", nativeQuery = true)
    ChatModel findChatByName(String chatName);

    @Query(value = "SELECT DISTINCT u.nickname\n" +
            "FROM txtalk_db.user u\n" +
            "JOIN txtalk_db.message m ON u.user_id = m.user_id\n" +
            "JOIN txtalk_db.chat c ON m.chat_id = c.chat_id\n" +
            "WHERE c.chat_id = ?1", nativeQuery = true)
    List<String> findAllUsersByChat(Integer chatId);
}
