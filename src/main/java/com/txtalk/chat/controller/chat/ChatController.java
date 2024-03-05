package com.txtalk.chat.controller.chat;

import com.txtalk.chat.model.chat.ChatModel;
import com.txtalk.chat.repository.chat.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {

    @Autowired
    ChatRepository chatRepository;

    @GetMapping("/all")
    public List<ChatModel> getAllChats(){
        return chatRepository.findAllChats();
    }
}
