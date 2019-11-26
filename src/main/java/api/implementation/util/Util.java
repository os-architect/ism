package api.implementation.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.json.JsonParseException;

import java.io.IOException;

public class Util {

    public static String toJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    public static <E> E fromJson(String json, Class<E> classDef) throws JsonParseException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, classDef);
    }

}
