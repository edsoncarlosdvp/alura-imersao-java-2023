package br.com.edson.exemple.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {

    private List<Language> languages = List.of(
        new Language(
            "Java",
            "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png",
            2
        ),
        new Language(
            "PHP",
            "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/php/php_256x256.png",
            7
        )
    );

    @GetMapping("/languages")
    public List<Language> getLanguages() {
        return languages;
    }

    @GetMapping("/linguagem-preferida")
    public String Name() {
        return "Oi, Java!";
    }
}
