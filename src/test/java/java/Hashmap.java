package java;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class Hashmap {
	
	@Test
	public void compareTwoHashmap() {
		Map<String, String> first = new HashMap<>();
		first.put("Name","Pritesh");
		System.out.println(first);
		
		Map<String, String> second = new HashMap<>();
		second.put("Name","Pritesh");
		System.out.println(second);
	}

}
