package donate.utils;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Object object) {
        try{
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException("Conversion to JSON failed for object: " + object + e.getMessage());
        }
    }

    // Convert JSON string to Java object
    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
