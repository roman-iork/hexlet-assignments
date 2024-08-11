package exercise;

import java.util.stream.Collectors;

import static java.util.Arrays.stream;

// BEGIN
public class App {
    public static String getForwardedVariables(String context) {
        String result = stream(context.split("]\n"))
                .flatMap(str -> stream(str.split("\"\n")))
                .filter(str1 -> str1.contains("environment=\""))
                .map(str2 -> str2.replace("environment=\"", ""))
                .flatMap(str3 -> stream(str3.split(",")))
                .filter(str4 -> str4.contains("X_FORWARDED_"))
                .map(str5 -> str5.replace("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
        return result;
    }
}
//END
