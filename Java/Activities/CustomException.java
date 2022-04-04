package Activities;

public class CustomException extends Exception {

	private String message;
	//message= "Passed";
		
	
	
	public CustomException(String message) {
		
		this.message=message;
		
		
	}
	@Override
	public String getMessage() {
	    return message;
	}

}
