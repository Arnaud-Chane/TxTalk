package com.txtalk.chat.service.mapper.message;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MessageChatUserMapper {
    @Mapping(source = "MessageModel.message_id", target = "message_id")

}
