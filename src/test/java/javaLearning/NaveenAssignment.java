package javaLearning;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class NaveenAssignment {

	public static void main(String args[]) {
		methodName("Pritesh", "Swati", "Pratiksha");
	}

	private static void methodName(String... stringNames) {
		List<String> stringList = new ArrayList<>();
		for (String name : stringNames) {
			stringList.add(name);
		}
		System.out.println(stringList);
		String mainFilterName = stringList.get(0);
		System.out.println(mainFilterName);

	}
}
