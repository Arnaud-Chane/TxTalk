package com.txtalk.chat.service.mapper.message;

import com.txtalk.chat.dto.message.MessageDto;
import com.txtalk.chat.model.entity.chat.ChatModel;
import com.txtalk.chat.model.entity.message.MessageModel;
import com.txtalk.chat.model.entity.user.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MessageChatUserMapper {
    @Mapping(source = "MessageModel.message_id", target = "message_id")
    @Mapping(source = "MessageModel.message_content", target = "message_content")
    @Mapping(source = "User.nickname", target = "nickname")
    @Mapping(source = "Chat.chat_name", target = "chat_name")
    @Mapping(source = "MessageModel.created_at", target = "created_at")
    MessageDto messageModelToMessageDto(MessageModel MessageModel, UserModel User, ChatModel Chat);

}
