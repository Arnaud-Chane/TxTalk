package com.txtalk.chat.service.message;

import com.txtalk.chat.dto.messageUserDto.MessageUserDto;
import com.txtalk.chat.model.entity.message.MessageModel;
import com.txtalk.chat.model.entity.user.UserModel;
import com.txtalk.chat.model.repository.message.MessageRepository;
import com.txtalk.chat.model.repository.user.UserRepository;
import com.txtalk.chat.service.mapper.messageUserMapper.MessageUserMapper;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private MessageRepository messageRepository;
    private UserRepository userRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, UserRepository userRepository){
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    public List<MessageUserDto> listMessagesByNickname(String nickname){
        UserModel user = userRepository.findUserByNickname(nickname);
        List<MessageModel> messages = messageRepository.findMessageByUserId(user.getUser_id());

        List<MessageUserDto> messageUserDtos = new ArrayList<>();
        for(MessageModel message : messages){
            MessageUserDto messageUserDto = MessageUserMapper.INSTANCE.from(user, message);
            messageUserDtos.add(messageUserDto);
        }

        return messageUserDtos;
    }




}
