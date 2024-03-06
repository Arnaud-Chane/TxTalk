package com.txtalk.chat.service.message;

import com.txtalk.chat.converter.message.MessageDTOConverter;
import com.txtalk.chat.dto.message.MessageDTO;
import com.txtalk.chat.model.message.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    MessageDTOConverter messageDTOConverter;

    public MessageDTO getMessageByNickname(){

        // Mock db call
        MessageModel message = new MessageModel();
        message.setMessage_id(12);
        message.setMessage_content("Hello from ModelService.");
        message.setUser_id(1);
        message.setChat_id(1);
        message.setCreated_at("2024-03-06 14:35:09");

        MessageDTO messageDTO = messageDTOConverter.convertMessageModeltoMessageDTO(message);
        return messageDTO;
    }

}
