package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {

    public static List<String> validate(Address address) {
        List<String> notValidFields = new ArrayList<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            NotNull notNullAnnotation = field.getAnnotation(NotNull.class);
            if (notNullAnnotation != null) {
                try {
                    field.setAccessible(true);
                    String value = (String) field.get(address);
                    if (value == null) {
                        notValidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return notValidFields;
    }

    public static Map<String, List<String>> advancedValidate(Address adress) {
        Map<String, List<String>> notValidAddress = new HashMap<>();
        for (Field field : adress.getClass().getDeclaredFields()) {
            NotNull notNullAnnotation = field.getAnnotation(NotNull.class);
            MinLength minLengthAnnotation = field.getAnnotation(MinLength.class);
            List<String> notValidMessage = new ArrayList<>();
            field.setAccessible(true);
            if (notNullAnnotation != null) {
                try {
                    String value = (String) field.get(adress);
                    if (value == null) {
                        notValidMessage.add("can not be null");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (minLengthAnnotation != null) {
                try {
                    String value = (String) field.get(adress);
                    int minLength = minLengthAnnotation.minLength();
                    if (value.length() < minLength) {
                        notValidMessage.add("length less than " + minLength);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (!notValidMessage.isEmpty()) {
                notValidAddress.put(field.getName(), notValidMessage);
            }
        }
        return notValidAddress;
    }

}
// END
