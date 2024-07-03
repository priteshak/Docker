package Individual_Test_Cases;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class hashmapconcepts {

	public static void main(String[] args) {

		Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        map1.put("key2", "value2");
        map1.put("key3", "value3");

        Map<String, String> map2 = new HashMap<>();
        map2.put("key1", "value1");
        map2.put("key2", "value2");
        map2.put("key4", "value3");

        // Compare the values
        boolean areValuesEqual = map1.values().equals(map2.values());

        if (areValuesEqual) {
            System.out.println("The values are equal.");
        } else {
            System.out.println("The values are not equal.");
        }

	}
}
