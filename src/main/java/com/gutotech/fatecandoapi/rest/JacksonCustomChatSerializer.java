package com.gutotech.fatecandoapi.rest;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.gutotech.fatecandoapi.model.Chat;
import com.gutotech.fatecandoapi.model.User;

/**
 * @author Gustavo Alves
 *
 */
public class JacksonCustomChatSerializer extends StdSerializer<Chat> {

	public JacksonCustomChatSerializer() {
		this(null);
	}

	public JacksonCustomChatSerializer(Class<Chat> t) {
		super(t);
	}

	@Override
	public void serialize(Chat chat, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

		jgen.writeStartObject();

		if (chat.getId() == null) {
			jgen.writeNullField("id");
		} else {
			jgen.writeNumberField("id", chat.getId());
		}

		jgen.writeStringField("name", chat.getName());
		jgen.writeStringField("creationDate", formatter.format(chat.getCreationDate()));
		jgen.writeBooleanField("pvt", chat.isPvt());
		jgen.writeBooleanField("blocked", chat.isBlocked());

		jgen.writeObjectFieldStart("lastMessage"); // start lastMessage
		jgen.writeNumberField("id", chat.getLastMessage().getId());
		jgen.writeStringField("body", chat.getLastMessage().getBody());
		jgen.writeBooleanField("newMessage", chat.getLastMessage().isNewMessage());

		jgen.writeObjectFieldStart("from"); // start from
		jgen.writeNumberField("id", chat.getLastMessage().getFrom().getId());
		jgen.writeStringField("fullName", chat.getLastMessage().getFrom().getFullName());
		jgen.writeStringField("email", chat.getLastMessage().getFrom().getEmail());
		jgen.writeBooleanField("authorizedTeacher", chat.getLastMessage().getFrom().isAuthorizedTeacher());
		jgen.writeEndObject(); // end from

		jgen.writeObjectFieldStart("to"); // start to
		jgen.writeNumberField("id", chat.getLastMessage().getTo().getId());
		jgen.writeStringField("fullName", chat.getLastMessage().getTo().getFullName());
		jgen.writeStringField("email", chat.getLastMessage().getTo().getEmail());
		jgen.writeBooleanField("authorizedTeacher", chat.getLastMessage().getTo().isAuthorizedTeacher());
		jgen.writeEndObject(); // end to

		jgen.writeEndObject(); // end lastMessage

		jgen.writeArrayFieldStart("users");
		for (User user : chat.getUsers()) {
			jgen.writeStartObject();
			jgen.writeNumberField("id", user.getId());
			jgen.writeStringField("fullName", user.getFullName());
			jgen.writeStringField("email", user.getEmail());
			jgen.writeBooleanField("authorizedTeacher", user.isAuthorizedTeacher());
			jgen.writeEndObject();
		}
		jgen.writeEndArray();

		jgen.writeEndObject();
	}

}
