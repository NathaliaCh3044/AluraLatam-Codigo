import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class AnalizadorJSON {
    public static double obtenerTasa(String json) {

        JsonObject objeto = JsonParser.parseString(json).getAsJsonObject();

        return objeto.get("conversion_rate").getAsDouble();
    }
}
