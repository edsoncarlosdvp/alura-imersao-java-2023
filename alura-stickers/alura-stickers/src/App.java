import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // String url = "https://imdb-api.com/en/API/Top250Movies/k_4l2nmlmg";
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";

        var adress = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(adress).GET().build();
        var response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        var parse = new JsonParser();
        List<Map<String, String>> listMovies = parse.parse(body);
        
        for (int i = 0; i < 10; i++) {
            Map<String, String> movie = listMovies.get(i);

            String urlImage = movie.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            String title = movie.get("title");

            var inputStream = new URL(urlImage).openStream();
            String fileName = title + ".png";

            var generator = new StickersGeneration();
            generator.Create(inputStream, fileName);

            System.out.println(title);
            System.out.println();
        }
    }
}
