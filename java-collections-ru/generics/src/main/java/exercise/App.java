package exercise;

//import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> list, Map<String, String> map) {
        var foundValues = new ArrayList<Map<String, String>>();
        var valuesToCompare = new ArrayList<String>();
        for (Map.Entry<String, String> pair : map.entrySet()) {
            valuesToCompare.add(pair.getValue());
        }
        int count;
        for (var element : list) {
            count = 0;
            for (String value : valuesToCompare) {
                if (element.containsValue(value)) {
                    count += 1;
                }
            }
            if (count == valuesToCompare.size()) {
                foundValues.add(element);
            }
        }
        return foundValues;
    }
}
//END
