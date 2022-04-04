package Activities;

public class MyBook extends Book{
	@Override
	public void setTitle(String Booktitle){
		
		title= Booktitle;
	}
	

	public static void main(String[] args) {

		Book myb= new MyBook();
		myb.setTitle("History");
		System.out.println("Title of the Book: "+myb.getTitle());
		
	}


}
