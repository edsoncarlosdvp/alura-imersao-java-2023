import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class JsonParser {
    private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)\\].*");
    private static final Pattern REGEX_ATTRIBUTES_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");

    public List<Map<String, String>> parse(String json) {
        var matcher = REGEX_ITEMS.matcher(json);
        if (!matcher.find()) {

            throw new IllegalArgumentException("Não encontrou items.");
        }

        String[] items = matcher.group(1).split("\\},\\{");

        List<Map<String, String>> dados = new ArrayList<>();

        for (String item : items) {

            Map<String, String> attributesItem = new HashMap<>();

            var matcherattributesJson = REGEX_ATTRIBUTES_JSON.matcher(item);
            while (matcherattributesJson.find()) {
                String attributes = matcherattributesJson.group(1);
                String value = matcherattributesJson.group(2);
                attributesItem.put(attributes, value);
            }

            dados.add(attributesItem);
        }

        return dados;
    }
}
