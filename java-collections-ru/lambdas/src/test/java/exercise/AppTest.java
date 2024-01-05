package exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

// BEGIN
class AppTest {
    @Test
    void app() {
        String[][] inputArray = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"}
        };
        String[][] expected = {
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"}
        };
        String[][] result = App.enlargeArrayImage(inputArray);
        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(result));
    }

    @Test
    void appEmpty() {
        String[][] inputArray = {};
        String[][] expected = {};
        String[][] result = App.enlargeArrayImage(inputArray);
        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(result));
    }

    @Test
    void appSmall() {
        String[][] inputArray = {
                {"*", "*", "*"},
                {"*", " ", "*"},
                {"*", "*", "*"}
        };
        String[][] expected = {
                {"*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", "*", "*"},
                {"*", "*", " ", " ", "*", "*"},
                {"*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*"}
        };
        String[][] result = App.enlargeArrayImage(inputArray);
        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(result));
    }
}
// END
