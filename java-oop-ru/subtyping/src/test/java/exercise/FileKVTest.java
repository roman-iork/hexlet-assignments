package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
// BEGIN
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();
    private static Map<String, String> mapForTest;

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    @BeforeEach
    public void beforeEachPlus() {
        try {
            Files.delete(filepath);
        } catch (Exception e) {
            System.out.println(e.getMessage() + " <- check this!");
        }
        mapForTest = new LinkedHashMap<>();
        mapForTest.put("one", "1");
        mapForTest.put("two", "2");
        mapForTest.put("three", "3");
    }

    // BEGIN
    @Test
    public void testFileKVConstructor() {
        String expected = "{\"one\":\"1\",\"two\":\"2\",\"three\":\"3\"}";
        FileKV testInstance = new FileKV(filepath.toString(), mapForTest);
        String actual = Utils.readFile(filepath.toString());
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSet() {
        String expected = "{\"one\":\"1\",\"two\":\"2\",\"three\":\"3\",\"four\":\"4\"}";
        FileKV testInstance = new FileKV(filepath.toString(), mapForTest);
        testInstance.set("four", "4");
        String actual = Utils.readFile(filepath.toString());
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testUnset() {
        String expected = "{\"two\":\"2\",\"three\":\"3\"}";
        FileKV testInstance = new FileKV(filepath.toString(), mapForTest);
        testInstance.unset("one");
        String actual = Utils.readFile(filepath.toString());
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testGet() {
        String expected = "2";
        FileKV testInstance = new FileKV(filepath.toString(), mapForTest);
        String actual = testInstance.get("two", "default");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testToMap() {
        Map<String, String> expected = mapForTest;
        FileKV testInstance = new FileKV(filepath.toString(), mapForTest);
        Map<String, String> actual = testInstance.toMap();
        assertThat(actual).isEqualTo(expected);
    }
    // END
}
