package exercise;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Address address = new Address(
                "Russia",
                "Izhevsk",
                null,
                null,
                null
        );
        List<String> notValidFields = Validator.validate(address);
        System.out.println(notValidFields);
    }
}
