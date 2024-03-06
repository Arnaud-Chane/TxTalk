package com.txtalk.chat.converter.message;

import com.txtalk.chat.dto.message.MessageDTO;
import com.txtalk.chat.model.message.MessageModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public MessageDTO convertMessageModeltoMessageDTO(MessageModel messageModel){
        MessageDTO messageDTO = modelMapper.map(messageModel, MessageDTO.class);

        return messageDTO;
    }

    public MessageModel convertMessageDTOtoMessageModel(MessageDTO messageDTO){
        MessageModel messageModel = modelMapper.map(messageDTO, MessageModel.class);

        return messageModel;
    }
}
