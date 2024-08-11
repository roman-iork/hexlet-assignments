package exercise;

import java.util.HashMap;
import java.util.Map;
//import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> mappedStorage = new HashMap<>(storage.toMap());
        Set<String> keys = mappedStorage.keySet();
        for (String key : keys) {
            storage.unset(key);
        }
        for (Map.Entry<String, String> entry : mappedStorage.entrySet()) {
            String newKey = entry.getValue();
            String newValue = entry.getKey();
            storage.set(newKey, newValue);
        }
    }
}
// END
