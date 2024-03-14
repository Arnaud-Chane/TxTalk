package com.txtalk.chat.service.mapper.messageUserMapper;

import com.txtalk.chat.dto.messageUserDto.MessageUserDto;
import com.txtalk.chat.model.entity.message.MessageModel;
import com.txtalk.chat.model.entity.user.UserModel;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MessageUserMapper {
    MessageUserMapper INSTANCE = Mappers.getMapper( MessageUserMapper.class );
    @Mapping(source="userModel.nickname", target="user_nickname")
    @Mapping(source="messageModel.message_content", target="msg_message_content")
    MessageUserDto from(UserModel userModel, MessageModel messageModel);



}
