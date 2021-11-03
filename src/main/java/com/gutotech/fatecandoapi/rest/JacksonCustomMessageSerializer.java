package com.gutotech.fatecandoapi.rest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.gutotech.fatecandoapi.model.Message;

/**
 * @author Gustavo Alves
 *
 */
public class JacksonCustomMessageSerializer extends StdSerializer<Message> {

	public JacksonCustomMessageSerializer() {
		this(null);
	}

	public JacksonCustomMessageSerializer(Class<Message> t) {
		super(t);
	}

	@Override
	public void serialize(Message message, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

		jgen.writeStartObject();

		if (message.getId() == null) {
			jgen.writeNullField("id");
		} else {
			jgen.writeNumberField("id", message.getId());
		}

		jgen.writeStringField("body", message.getBody());
		jgen.writeBooleanField("newMessage", message.isNewMessage());
		jgen.writeStringField("date", formatter.format(message.getDate()));

		jgen.writeObjectFieldStart("from"); // start from
		jgen.writeNumberField("id", message.getFrom().getId());
		jgen.writeStringField("fullName", message.getFrom().getFullName());
		jgen.writeStringField("email", message.getFrom().getEmail());
		jgen.writeBooleanField("authorizedTeacher", message.getFrom().isAuthorizedTeacher());
		jgen.writeEndObject(); // end from

		jgen.writeObjectFieldStart("to"); // start to
		jgen.writeNumberField("id", message.getTo().getId());
		jgen.writeStringField("fullName", message.getTo().getFullName());
		jgen.writeStringField("email", message.getTo().getEmail());
		jgen.writeBooleanField("authorizedTeacher", message.getTo().isAuthorizedTeacher());
		jgen.writeEndObject(); // end to

		jgen.writeEndObject();
	}

}
