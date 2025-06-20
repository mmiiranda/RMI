package com.biblioteca;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Serializador {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static byte[] toJson(Object obj) throws IOException {
        return mapper.writeValueAsBytes(obj);  
    }

    public static <T> T fromJson(byte[] json, Class<T> type) throws IOException {
        return mapper.readValue(json, type);
    }
}
