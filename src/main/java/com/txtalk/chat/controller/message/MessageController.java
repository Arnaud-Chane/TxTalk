package com.txtalk.chat.controller.message;

import com.txtalk.chat.dto.message.MessageDTO;
import com.txtalk.chat.model.message.MessageModel;
import com.txtalk.chat.repository.message.MessageRepository;
import com.txtalk.chat.service.message.MessageService;
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

    @Autowired
    MessageService messageService;

    @PostMapping("/nickname")
//    public List<MessageDTO> getMessagesByNickname (@RequestBody Map < String, String > body){
//        List<MessageDTO> listMessagesByNickname = messageRepository.findMessagesByUser(body.get("nickname"));
//        return messageService.getMessageByNickname();

    public List<Object[]> getMessagesByNickname(@RequestBody Map<String, String> body) {
        List<Object[]> listMessagesByNickname = messageRepository.findMessagesByUser(body.get("nickname"));
        return listMessagesByNickname;
    }

    // TODO : getMessagesByChat
}
