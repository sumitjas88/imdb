package com.sumit.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.sumit.common.Rating;

import java.io.IOException;

public class RatingTypeSerializer extends JsonSerializer<Rating>{
    @Override
    public void serialize(Rating value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeFieldName("code");
        jgen.writeString(value.getCode());
        jgen.writeFieldName("description");
        jgen.writeString(value.getDescription());
        jgen.writeEndObject();
    }
}
