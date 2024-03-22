package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



class ValidationTest {

    @Test
    void testValidate() {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        List<String> result1 = Validator.validate(address1);
        List<String> expected1 = List.of();
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address(null, "London", "1-st street", "5", "1");
        List<String> result2 = Validator.validate(address2);
        List<String> expected2 = List.of("country");
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address("USA", null, null, null, "1");
        List<String> result3 = Validator.validate(address3);
        List<String> expected3 = List.of("city", "street", "houseNumber");
        assertThat(result3).isEqualTo(expected3);
    }

    // BEGIN
    @Test
    void testAdvancedValidate() {
        Address address1 = new Address("Russia",
                "Izhevsk",
                "Pushkinskaya",
                "_186",
                "47"
        );
        Map<String, List<String>> expected1 = new HashMap<>(Map.of());
        Map<String, List<String>> actual1 = Validator.advancedValidate(address1);
        assertThat(actual1).isEqualTo(expected1);

        Address address2 = new Address("Russia",
                "Izhevsk",
                "Pushkinskaya",
                "186",
                "47"
        );
        Map<String, List<String>> expected2 = new HashMap<>(Map.of("houseNumber", List.of("length less than 4")));
        Map<String, List<String>> actual2 = Validator.advancedValidate(address2);
        assertThat(actual2).isEqualTo(expected2);

        Address address3 = new Address("Russia",
                "Izhevsk",
                null,
                "186",
                "47"
        );
        Map<String, List<String>> expected3 = new HashMap<>(Map.of(
                "street", List.of("can not be null"),
                "houseNumber", List.of("length less than 4")));
        Map<String, List<String>> actual3 = Validator.advancedValidate(address3);
        assertThat(actual3).isEqualTo(expected3);

        Address address4 = new Address("Russia",
                "Izhevsk",
                null,
                "186",
                null
        );
        Map<String, List<String>> expected4 = new HashMap<>(Map.of(
                "street", List.of("can not be null"),
                "houseNumber", List.of("length less than 4")));
        Map<String, List<String>> actual4 = Validator.advancedValidate(address4);
        assertThat(actual4).isEqualTo(expected4);
    }
    // END
}
