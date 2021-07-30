package com.gutotech.fatecandoapi.rest;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.gutotech.fatecandoapi.model.Alternative;

/**
 * @author Gustavo Alves
 *
 */
public class JacksonCustomAlternativeSerializer extends StdSerializer<Alternative> {

	public JacksonCustomAlternativeSerializer() {
		this(null);
	}

	public JacksonCustomAlternativeSerializer(Class<Alternative> t) {
		super(t);
	}

	@Override
	public void serialize(Alternative alternative, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		jgen.writeStartObject();
		
		if (alternative.getId() == null) {
			jgen.writeNullField("id");
		} else {
			jgen.writeNumberField("id", alternative.getId());
		}

		jgen.writeStringField("description", alternative.getDescription());

		jgen.writeEndObject();
	}

}
