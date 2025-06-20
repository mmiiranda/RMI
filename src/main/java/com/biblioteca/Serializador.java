package com.biblioteca;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Serializador {
    private static final ObjectMapper mapper = new ObjectMapper();

    // Método para serializar um objeto para JSON
    public static byte[] toJson(Object obj) throws IOException {
        return mapper.writeValueAsBytes(obj);  // Serializa o objeto em JSON
    }

    // Método para desserializar um JSON em um objeto
    public static <T> T fromJson(byte[] json, Class<T> type) throws IOException {
        return mapper.readValue(json, type);  // Desserializa o JSON de volta para o objeto
    }
}
