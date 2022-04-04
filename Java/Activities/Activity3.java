package Activities;

public class Activity3 {

	double seconds = 1000000000;

	double EarthSeconds = 31557600;
	double MercurySeconds = 0.2408467;
	double VenusSeconds = 0.61519726;
	double MarsSeconds = 1.8808158;
	double JupiterSeconds = 11.862615;
	double SaturnSeconds = 29.447498;
	double UranusSeconds = 84.016846;
	double NeptuneSeconds = 164.79132;

	public static void main(String[] args) {
		Activity3 act3 = new Activity3();
		double earthAge = (act3.seconds / act3.EarthSeconds);
		System.out.println("Earth age: " + earthAge);
		System.out.println("Mercury age: " + (earthAge / act3.MercurySeconds));
		System.out.println("Venus age: " + (earthAge/ act3.VenusSeconds));
		System.out.println("Mars age: " + (earthAge / act3.MarsSeconds));
		System.out.println("Jupiter age: " + (earthAge/ act3.JupiterSeconds));
		System.out.println("Saturn age: " + (earthAge / act3.SaturnSeconds));
		System.out.println("Uranus age: " + (earthAge/ act3.UranusSeconds));
		System.out.println("Neptune age: " + (earthAge / act3.NeptuneSeconds));
	}

}
