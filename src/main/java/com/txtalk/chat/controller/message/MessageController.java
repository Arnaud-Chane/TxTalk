package com.txtalk.chat.controller.message;

import com.txtalk.chat.dto.messageUserDto.MessageUserDto;
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
    MessageService messageService;

    @PostMapping("/nickname")
    public List<MessageUserDto> getMessagesByNickname(@RequestBody Map<String, String> body){
        List<MessageUserDto> listMessagesByNickname = messageService.listMessagesByNickname(body.get("nickname"));
        return listMessagesByNickname;
    }

    // TODO : getMessagesByChat
}
