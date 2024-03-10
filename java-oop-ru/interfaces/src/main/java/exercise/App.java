package exercise;

import java.util.Comparator;
import java.util.List;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int number) {
        return apartments.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .limit(number)
                .map(Home::toString)
                .toList();
    }
}
// END
