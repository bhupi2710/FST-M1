package Activities;

public class Car {

	String color;
	String transmisssion;
	int make;
	int tyres;
	int doors;

	public Car() {

		tyres = 4;
		doors = 4;
	}

	public void displayCharacteristics() {

		System.out.println("Tyres " + tyres);
		System.out.println("transmisssion " + transmisssion);
		System.out.println("make " + make);
		System.out.println("color " + color);
		System.out.println("doors " + doors);
	}

	public void accelarate() {

		System.out.println("Car is moving forward.");
	}

	public void brake() {

		System.out.println("Car has stopped.");
	}

}
