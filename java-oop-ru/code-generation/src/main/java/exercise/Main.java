package exercise;

public class Main {
    public static void main(String[] args) throws Exception {
        var user = new User(1, "Name", "LastName", 26);
        var car = new Car(2, "Lada", "2110", "yellow", user);
        var jsonView = car.serialize();
        System.out.println(jsonView);
        System.out.println();
        var car2 = Car.unserialize(jsonView);
        System.out.println(car2);
    }
}
