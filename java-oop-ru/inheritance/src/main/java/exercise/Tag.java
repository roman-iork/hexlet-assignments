package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    protected String name;
    protected Map<String, String> attributes;

    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }
    @Override
    public String toString() {
        if (attributes.isEmpty()) {
            return String.format("<%s>", name);
        }
        String attributesAsString = mapToTagString();
        return String.format("<%s%s>", name, attributesAsString);
    }

    protected String mapToTagString() {
        if (attributes.isEmpty()) {
            return "";
        }
        return " " + attributes.keySet().stream()
                .map(key -> key + "=\"" + attributes.get(key) + "\"")
                .collect(Collectors.joining(" "));
    }
}
// END
