package Activities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Activity10 {


	public static void main(String[] args) throws Exception {
		
		Set<String> hs= new HashSet<String>();
		hs.add("One");
		hs.add("Two");
		hs.add("Three");
		hs.add("Four");
		hs.add("Five");
		
		for (String name : hs) {
			System.out.println("Name: "+name);
		}
		
		System.out.println("HashSet contacins: "+hs.contains("Four"));
		System.out.println("Size of HashSet : "+hs.size());
		hs.remove("Five");
		System.out.println("Size of HashSet : "+hs.size());
		
	}
	
}
