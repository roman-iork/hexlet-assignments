package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
//import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path path, Car car) throws Exception {
        String jsonViewOfCar = car.serialize();
        Files.write(path, jsonViewOfCar.getBytes());
    }

    public static Car extract(Path path) throws IOException {
        String jsonViewOfCar = Files.readString(path);
        return Car.unserialize(jsonViewOfCar);
    }
}
// END
