package com.gutotech.fatecandoapi.rest;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.gutotech.fatecandoapi.model.Message;
import com.gutotech.fatecandoapi.model.Role;

public class JacksonCustomMessageSerializer extends StdSerializer<Message> {
	private static final long serialVersionUID = 1L;

	public JacksonCustomMessageSerializer() {
		this(null);
	}

	protected JacksonCustomMessageSerializer(Class<Message> t) {
		super(t);
	}

	@Override
	public void serialize(Message message, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		jgen.writeStartObject();

		jgen.writeNumberField("id", message.getId());
		jgen.writeStringField("subject", message.getSubject());
		jgen.writeStringField("text", message.getText());

		jgen.writeObjectFieldStart("from"); // start from
		jgen.writeNumberField("id", message.getFrom().getId());
		jgen.writeStringField("firstName", message.getFrom().getFirstName());
		jgen.writeStringField("lastName", message.getFrom().getLastName());
		jgen.writeStringField("email", message.getFrom().getEmail());

		jgen.writeArrayFieldStart("roles"); // start roles
		for (Role role : message.getFrom().getRoles()) {
			jgen.writeStartObject();
			jgen.writeNumberField("id", role.getId());
			jgen.writeStringField("name", role.getName());
			jgen.writeEndObject();
		}
		jgen.writeEndArray(); // end roles

		jgen.writeEndObject(); // end from

		Format formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		jgen.writeStringField("date", formatter.format(message.getDate()));

		jgen.writeEndObject();
	}

}
