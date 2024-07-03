package Individual_Test_Cases;

import java.util.HashMap;
import java.util.Map;

public class Hash {

	public static void main(String[] args) {

		Map<Integer, String> names = new HashMap<>();
		names.put(1, "One");
		names.put(2, "Two");
		names.put(3, "Three");
		names.put(4, "Four");
		names.put(5, "Five");
		
		Map<Integer, String> namesFirst = new HashMap<>();
		namesFirst.put(1, "One");
		namesFirst.put(2, "Two");
		namesFirst.put(3, "Three");
		namesFirst.put(4, "Four");
		namesFirst.put(5, "Five");
		
		Map<Integer, String> namesSecond = new HashMap<>();
		namesSecond.put(1, "One");
		namesSecond.put(2, "Two");
		namesSecond.put(3, "Three");
		namesSecond.put(4, "Four");
		namesSecond.put(5, "Five");

		System.out.println(names);
		System.out.println("=======================");
		for (Integer printKeys : names.keySet()) {
			System.out.println(printKeys);
		}
		System.out.println("=======================");
		for (String printValues : names.values()) {
			System.out.println(printValues);
		}
		System.out.println("=======================");
		for (Integer printKeys : names.keySet()) {
			if (printKeys.equals(3)) {
				System.out.println(names.get(4));
			}
		}
		for (Map.Entry<Integer, String> iterating : names.entrySet()) {
			System.out.println(iterating.getKey() + " " +iterating.getValue());
			if(iterating.getKey().equals(3)) {
				System.out.println(iterating.getValue());
			}

		}
	}

}
