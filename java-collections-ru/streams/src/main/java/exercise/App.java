package exercise;

import java.util.List;

// BEGIN
public class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        List<String> freeEmail = List.of("gmail.com", "yandex.ru", "hotmail.com");
        long result = emails.stream()
                .map(email -> email.split("@"))
                .map(arrayElement -> arrayElement[1])
                .filter(element -> freeEmail.contains(element))
                .count();
        return result;
    }
}
// END
