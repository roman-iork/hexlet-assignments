package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, String> res = new LinkedHashMap<>();
        Set<String> keySet = new TreeSet<>();
        for (Map.Entry<String, Object> entry : map1.entrySet()) {
            keySet.add(entry.getKey());
        }
        for (Map.Entry<String, Object> entry : map2.entrySet()) {
            keySet.add(entry.getKey());
        }

        for (String key : keySet) {
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                res.put(key, "deleted");
            } else if (map1.containsKey(key) && map2.containsKey(key) && (!map2.get(key).equals(map1.get(key)))) {
                res.put(key, "changed");
            } else if (map1.containsKey(key) && map2.containsKey(key) && (map2.get(key).equals(map1.get(key)))) {
                res.put(key, "unchanged");
            } else if (map2.containsKey(key) && !map1.containsKey(key)) {
                res.put(key, "added");
            } else {
                throw new IllegalArgumentException("extra key added!");
            }
        }
        return res;
    }
}
//END
