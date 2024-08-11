package exercise;

import java.util.Arrays;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] imageArray) {
        if (imageArray.length == 0) {
            String[][] result = {};
            return result;
        }
        String[][] intermediateResult = Arrays.stream(imageArray)
                .map(element -> {
                    String[] enlargedFirstDimension = new String[element.length * 2];
                    int count = 0;
                    for (String e : element) {
                        enlargedFirstDimension[count] = e;
                        count += 1;
                        enlargedFirstDimension[count] = e;
                        count += 1;
                    }
                    return enlargedFirstDimension;
                })
                .toArray(String[][]::new);
        String[][] result = new String[imageArray.length * 2][intermediateResult[0].length];
        int count = 0;
        for (String[] enlargedElement : intermediateResult) {
            result[count] = enlargedElement;
            count += 1;
            result[count] = enlargedElement;
            count += 1;
        }
        return result;
    }
}
// END
