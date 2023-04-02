import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // String url = "https://imdb-api.com/en/API/Top250Movies/k_4l2nmlmg";
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        var extractor = new ExtractorContentImdb();

        var response = new ClientHttp();
        var json = response.searchData(url);

        List<Content> contents = extractor.extractorContent(json);

        var generator = new StickersGeneration();
        
        for (int i = 0; i < 3; i++) {
            var content = contents.get(i);

            var inputStream = new URL(content.getUrlImage()).openStream();
            String fileName = content.getTitle() + ".png";

            generator.Create(inputStream, fileName);

            System.out.println(content.getTitle());
            System.out.println();
        }
    }
}
