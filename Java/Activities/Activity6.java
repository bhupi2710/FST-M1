package Activities;

import java.util.ArrayList;
import java.util.List;

public class Activity6 {

	public static void main(String[] args) throws Exception {

		Plane p= new Plane(10);
		List<String> pass= new ArrayList<String>();
		pass.add("Madhura");
		p.onboard(pass);
		System.out.println("Time of take off: "+p.takeOff());
		System.out.println("List of passangers: "+p.getPassesngers());
		Thread.sleep(1000);
		p.land();
		System.out.println("Time of land: "+p.getLastTimeLanded());
	}

}
