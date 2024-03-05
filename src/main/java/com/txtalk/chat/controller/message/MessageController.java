package com.txtalk.chat.controller.message;

import com.txtalk.chat.model.message.MessageModel;
import com.txtalk.chat.repository.message.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/message")
@RequiredArgsConstructor
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    @PostMapping("/nickname")
    public List<MessageModel> getMessagesByNickname(@RequestBody Map<String, String> body){
        List<MessageModel> listMessagesByNickname = messageRepository.findMessagesByUser(body.get("nickname"));
        return listMessagesByNickname;
    }

    // TODO : getMessagesByChat
}
