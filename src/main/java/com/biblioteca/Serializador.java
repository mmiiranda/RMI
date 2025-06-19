package com.biblioteca;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import java.io.IOException;

public class Serializador {
    private static final ObjectMapper mapper = new ObjectMapper();
    
    static {
        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                .allowIfSubType("com.biblioteca")
                .build();
        mapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);
    }
    
    public static byte[] toJson(Object obj) throws IOException {
        return mapper.writeValueAsBytes(obj);
    }
    
    public static <T> T fromJson(byte[] json, Class<T> type) throws IOException {
        return mapper.readValue(json, type);
    }
}