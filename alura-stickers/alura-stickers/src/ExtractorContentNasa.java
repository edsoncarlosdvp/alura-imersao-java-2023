import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractorContentNasa implements ExtractorContent {
    public List<Content> extractorContent(String json) {
        var parse = new JsonParser();
        List<Map<String, String>> listData = parse.parse(json);
        List<Content> contents = new ArrayList<>();

        for (Map<String, String> attributes : listData) {
            String title = attributes.get("title");
            String urlImage = attributes.get("url");
            var content = new Content(title, urlImage);

            contents.add(content);
        }
        return contents;
    }
}
