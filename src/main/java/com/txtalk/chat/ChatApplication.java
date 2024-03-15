package com.txtalk.chat;

import com.txtalk.chat.dto.messageUserDto.MessageUserDto;
import com.txtalk.chat.model.entity.message.MessageModel;
import com.txtalk.chat.model.entity.user.UserModel;
import com.txtalk.chat.service.mapper.messageUserMapper.MessageUserMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.List;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);

		// given a customer
		UserModel customer = new UserModel("Max");

// and some address
		MessageModel homeAddress = new MessageModel("123 Some Street");

// when calling DeliveryAddressMapper::from
		MessageUserDto deliveryAddress = MessageUserMapper.INSTANCE.from(customer, homeAddress);
		System.out.println(deliveryAddress.getUser_nickname());
		System.out.println(deliveryAddress.getMsg_message_content());
	}

}
