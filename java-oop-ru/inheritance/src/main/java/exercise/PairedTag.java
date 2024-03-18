package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String text;
    private List<Tag> tags;

    public PairedTag(String name, Map<String, String> attributes, String text, List<Tag> tags) {
        super(name, attributes);
        this.text = text;
        this.tags = tags;
    }
    @Override
    public String toString() {
        String attributesAsString = mapToTagString();
        String tagsAsString = tags.stream()
                .map(Tag::toString)
                .collect(Collectors.joining());
        return String.format("<%s%s>%s%s</%s>", name, attributesAsString, text, tagsAsString, name);
    }
}
// END
