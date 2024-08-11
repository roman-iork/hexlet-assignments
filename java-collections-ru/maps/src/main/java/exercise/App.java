package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String phrase) {
        var wordCount = new HashMap<String, Integer>();
        if (phrase.length() == 0) {
            return wordCount;
        }
        var wordArray = phrase.split(" ");
        for (String word : wordArray) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        return wordCount;
    }

    public static String toString(Map<String, Integer> wordCountMap) {
        if (wordCountMap.isEmpty()) {
            return "{}";
        }
        var keySet = wordCountMap.keySet();
        var stringView = "{\n";
        for (var key : keySet) {
            stringView += "  " + key + ": " + wordCountMap.get(key) + "\n";
        }
        stringView += "}";
        return stringView;
    }
}
//END
