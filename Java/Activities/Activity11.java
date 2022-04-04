package Activities;
import java.util.HashMap;
import java.util.Map;

public class Activity11 {


	public static void main(String[] args) throws Exception {
		
		Map<Integer,String> hm= new HashMap<Integer,String>();
		hm.put(1,"White");
		hm.put(2,"Black");
		hm.put(3,"Green");
		hm.put(4,"Red");
		hm.put(5,"Yellow");
						
		System.out.println("HashSet contacins: "+hm.containsValue("Green"));
		System.out.println("Size of HashSet : "+hm.size());
		hm.remove(1);
		System.out.println("Size of HashSet : "+hm.size());
		
	}
	
}
