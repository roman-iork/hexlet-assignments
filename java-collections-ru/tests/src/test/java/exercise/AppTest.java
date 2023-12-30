package exercise;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> actual1 = App.take(List.of(7, 8, 9, 10), 3);
        List<Integer> expected1 = List.of(7, 8, 9);
        Assertions.assertEquals(actual1, expected1);
    }

    @Test
    void testTakeEmptyList() {
        List<Integer> actual2 = App.take(List.of(), 3);
        List<Integer> expected2 = new ArrayList<>();
        Assertions.assertEquals(actual2, expected2);
    }

    @Test
    void testTakeZeroCount() {
        List<Integer> actual3 = App.take(List.of(1, 2, 3, 4), 0);
        List<Integer> expected3 = new ArrayList<>();
        Assertions.assertEquals(actual3, expected3);
    }

    @Test
    void testTakeCountMoreThenListLength() {
        List<Integer> actual4 = App.take(List.of(4, 5, 6, 7, 8, 9), 8);
        List<Integer> expected4 = List.of(4, 5, 6, 7, 8, 9);
        Assertions.assertEquals(actual4, expected4);
        // END
    }
}
