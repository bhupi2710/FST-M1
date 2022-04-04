package Activities;

import java.util.Arrays;

public class Activiry2 {

	private boolean sumOfTens(int a[]) {
		boolean b = false;
		int sum = 0;
		
		int size = a.length;
		for (int i = 0; i < size; i++) {

			if (a[i] == 10) {

				sum += a[i];
			} else {

				System.out.println("Number in the array is skipped");
			}

		}
		b = (sum == 30);

		return b;

	}

	public static void main(String[] args) {

		Activiry2 act2 = new Activiry2();
		int a[] = { 10, 77, 10, 54, -11, 10 };
		System.out.println("Original Array: " + Arrays.toString(a));
		System.out.println("The Sum of the all 10s number is equal to 30: " + act2.sumOfTens(a));
	}

}
