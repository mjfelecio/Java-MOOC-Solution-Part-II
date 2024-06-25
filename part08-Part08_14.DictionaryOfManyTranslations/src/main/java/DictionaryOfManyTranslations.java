import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {
    private HashMap<String, ArrayList<String>> dictionary;

    public DictionaryOfManyTranslations() {
        this.dictionary = new HashMap<>();
    }

    public void add(String word, String translation) {
        this.dictionary.putIfAbsent(word, new ArrayList<>());

        ArrayList<String> translations = this.dictionary.get(word);

        translations.add(translation);

    }

    public ArrayList<String> translate(String word) {
        for (String key: this.dictionary.keySet()) {
            if (key.equals(word)) {
                return this.dictionary.get(key);
            }
        }
        return new ArrayList<>();
    }

    public void remove(String word) {
        this.dictionary.remove(word);
    }
}