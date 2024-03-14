package com.txtalk.chat.service.mapper.message;

import com.txtalk.chat.dto.message.MessageDto;
import com.txtalk.chat.model.entity.message.MessageModel;
import com.txtalk.chat.model.entity.user.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MessageChatUserMapper {
    @Mapping(source = "messageModel.message_id", target = "message_id")
    @Mapping(source = "messageModel.message_content", target = "message_content")
    @Mapping(source = "userModel.nickname", target = "nickname")
    @Mapping(source = "messageModel.created_at", target = "created_at")
    MessageDto messageModelToMessageDto(MessageModel messageModel, UserModel userModel);

}
