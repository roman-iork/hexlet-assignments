package exercise;

import java.util.ArrayList;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {
        //compare lengths
        if (symbols.length() < word.length()) {
            return false;
        }
        //turn symbols-string to list
        var symbolsAsArray = symbols.toCharArray();
        var symbolsAsList = new ArrayList<>();
        for (var symbol : symbolsAsArray) {
            symbolsAsList.add(symbol);
        }
        //turn word-string to lower case and to list
        var wordLowerCase = word.toLowerCase();
        var wordAsArray = wordLowerCase.toCharArray();
        var wordAsList = new ArrayList<>();
        for (var letter : wordAsArray) {
            wordAsList.add(letter);
        }
        //if letter isn't in symbols - return false, else - remove it from symbols
        for (var letter : wordAsList) {
            if (!symbolsAsList.contains(letter)) {
                return false;
            } else {
                symbolsAsList.remove(letter);
            }
        }
        //return true if all necessary symbols are present
        return true;
    }
}
//END
