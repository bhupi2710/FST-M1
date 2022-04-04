package Activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {

	
	
	public static void main(String[] args) throws Exception {
		
		List<String> myList= new ArrayList<String>();
		myList.add("One");
		myList.add("Two");
		myList.add("Three");
		myList.add("Four");
		myList.add("Five");
		
		for (String name : myList) {
			System.out.println("Name: "+name);
		}
		
		System.out.println("Third element in Arraylist: "+myList.get(2));
		System.out.println("Arraylist contacins: "+myList.contains("Four"));
		System.out.println("Size of Arraylist : "+myList.size());
		myList.remove("Five");
		System.out.println("Size of Arraylist : "+myList.size());
		
	}
	
}
