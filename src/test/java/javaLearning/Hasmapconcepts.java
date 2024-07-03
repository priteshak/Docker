package javaLearning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class Hasmapconcepts {

	@Test(enabled = false)
	public void compareTwoHashmap() {
		Map<String, String> first = new HashMap<>();
		first.put("Name", "Pritesh");
		System.out.println(first);

		Map<String, String> second = new HashMap<>();
		second.put("Name", "Pritesh");
		System.out.println(second);

		boolean result = first.equals(second);
		System.out.println(result);
	}

	@Test(enabled = false)
	public void compareTwoHashmapKey() {
		Map<String, String> first = new HashMap<>();
		first.put("Name", "Pritesh");
		System.out.println("Key" + first.keySet());

		Map<String, String> second = new HashMap<>();
		second.put("Namce", "Pritesh");
		System.out.println("Key" + second.keySet());

		boolean result = first.keySet().equals(second.keySet());
		System.out.println(result);
	}

	@Test(enabled = false)
	public void compareTwoHashmapValue() {
		Map<String, String> first = new HashMap<>();
		first.put("Name", "Pritesh");
		first.put("Namesecond", "Ekta");

		Map<String, String> second = new HashMap<>();
		second.put("Name", "Pritesh");
		second.put("Namesecond", "Ekta");
		for (String compare : first.keySet()) {
			System.out.println(first.get(compare));

			if (second.get(compare).equals(first.get(compare))) {
				System.out.println("Good");
			} else {
				System.out.println("Error");
			}
		}

	}

	@Test(enabled = false)
	public void addArrayListIntoHashMap() {
		// Create a HashMap to store lists of values
		Map<String, List<Integer>> hashMap = new HashMap<>();

		// Create a list of values
		List<Integer> valuesList1 = new ArrayList<>();
		valuesList1.add(10);
		valuesList1.add(20);
		valuesList1.add(30);

		List<Integer> valuesList2 = new ArrayList<>();
		valuesList2.add(15);
		valuesList2.add(25);
		valuesList2.add(35);

		// Add lists to the HashMap with corresponding keys
		hashMap.put("key1", valuesList1);
		hashMap.put("key2", valuesList2);

		// Example: Print the HashMap
		for (Map.Entry<String, List<Integer>> entry : hashMap.entrySet()) {
			String key = entry.getKey();
			List<Integer> values = entry.getValue();

			System.out.println("Key: " + key + ", Values: " + values);
		}
	}

	@Test(enabled = true)
	public void compareTwoHashmapValueSecondMethod() {
		Map<String, String> first = new HashMap<>();
		first.put("Name", "Pritesh");
		first.put("Namesecond", "Ektna");

		Map<String, String> second = new HashMap<>();
		second.put("Name", "Ekta");
		second.put("Namesecond", "Pritesh");
		for (String firstValues : first.values()) {
			if (second.containsValue(firstValues)) {
				System.out.println("Good");
			}
			else {
				System.out.println("Bad");
			}

		}

	}
}
