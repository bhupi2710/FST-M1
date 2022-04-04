package Activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
	
	public Plane(int count) {
		
		maxPassengers=count;
		passengers=new ArrayList();
	}
	    private List<String> passengers;
	    private int maxPassengers;
	    private Date lastTimeTookOf;
	    private Date lastTimeLanded;
	    public void onboard(List<String> onpassengers) {
	    	passengers.addAll(onpassengers);
	    	
	    }
	    
	    public Date takeOff() {
	    	
	    return new Date();
	    }
	    public void land() {
	    	lastTimeLanded= new Date();
	    	passengers.clear();
	    	
	    }
	    public Date getLastTimeLanded() {
	    	
	    	return lastTimeLanded;
	    }
	    public List<String> getPassesngers() {
	    	
	    	return passengers;
	    }

}
