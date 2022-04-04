package Activities;

public class Activity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Activity8 a = new Activity8();
		try {
			a.exceptionTest("Print Exception");
			a.exceptionTest(null);
			CustomException ex= new CustomException("");
			ex.getMessage();
		
		} catch (CustomException e) {
			// TODO Auto-generated catch block

			System.out.println(e.getMessage());
		}

	}

	public void exceptionTest(String str) throws CustomException {

		if (str == null) {

			throw new CustomException("The String is null");
		} else {

			System.out.println(str);
		}
	}
}
