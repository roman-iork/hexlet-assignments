package exercise;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String path;
    private Map<String, String> data;

    public FileKV(String path, Map<String, String> data) {
        this.path = path;
        this.data = new LinkedHashMap<>(data);
        try {
            Files.writeString(Path.of(path), "", StandardOpenOption.CREATE);
        } catch (Exception e) {
            System.out.println(e.getMessage() + " <- check this!");
        }
        sendToFile();
    }

    public void set(String key, String value) {
        data.put(key, value);
        sendToFile();
    }

    public void unset(String key) {
        data.remove(key);
        sendToFile();
    }

    public String get(String key, String defaultValue) {
        return data.getOrDefault(key, defaultValue);
    }

    public Map<String, String> toMap() {
        return new HashMap<>(data);
    }

    private void sendToFile() {
        try {
            String dataInJson = Utils.serialize(data);
            Files.delete(Path.of(path));
            Files.writeString(Path.of(path), dataInJson, StandardOpenOption.CREATE);
        } catch (Exception e) {
            System.out.println(e.getMessage() + " <- check this!");
        }
    }
}
// END
