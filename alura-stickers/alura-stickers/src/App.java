import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://imdb-api.com/en/API/Top250Movies/k_4l2nmlmg";

        var adress = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(adress).GET().build();
        var response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        var parse = new JsonParser();
        List<Map<String, String>> listMovies = parse.parse(body);
        
        for (Map<String, String> movies : listMovies) {
            System.out.println(movies.get("title"));
            System.out.println(movies.get("image"));
            System.out.println(movies.get("imDbRating"));
            System.out.println();
        }
    }
}
