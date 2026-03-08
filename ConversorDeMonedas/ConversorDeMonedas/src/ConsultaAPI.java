import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    public static String obtenerDatos(String base, String destino) {

        String apiKey = "97024ad63d01540d2f19ce83";
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + base + "/" + destino;

        try {

            HttpClient cliente = HttpClient.newHttpClient();

            HttpRequest solicitud = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

            return respuesta.body();

        } catch (Exception e) {
            System.out.println("Error al consultar la API");
            return null;
        }
    }
}
