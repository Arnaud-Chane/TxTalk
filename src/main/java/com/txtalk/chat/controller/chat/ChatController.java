package com.txtalk.chat.controller.chat;

import com.txtalk.chat.model.chat.ChatModel;
import com.txtalk.chat.model.user.UserModel;
import com.txtalk.chat.repository.chat.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {

    @Autowired
    ChatRepository chatRepository;

    @GetMapping("/all")
    public List<ChatModel> getAllChats() {
        return chatRepository.findAllChats();
    }

    @GetMapping("/{chatName}/users")
    public List<UserModel> getUsersByChat(@PathVariable("chatName") String chatName) {
        return chatRepository.findAllUsersByChat(chatName);
    }
}
