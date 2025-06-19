import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Serializador {
    private static final ObjectMapper mapper = new ObjectMapper();
    
    public static byte[] toJson(Object obj) throws IOException {
        return mapper.writeValueAsBytes(obj);
    }
    
    public static Object fromJson(byte[] json) throws IOException {
        return mapper.readValue(json, Object.class);
    }
}