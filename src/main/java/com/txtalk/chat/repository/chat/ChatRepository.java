package com.txtalk.chat.repository.chat;

import com.txtalk.chat.model.chat.ChatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatRepository extends JpaRepository<ChatModel, Integer> {

    @Query(value = "SELECT * FROM chat", nativeQuery = true)
    List<ChatModel> getAllChats();
}
