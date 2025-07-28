package activities;

import java.util.Arrays;

public class Activity2 {

	public static void main(String[] args) {
		// Array initialize
		int [] data = {10, 20, 10, 54, -11, 10};
		int a = 10 ;
		int b = 30 ;
     System.out.println("Original Array is : " + Arrays.toString(data));
     System.out.println("Result is : " + result(data ,a ,b));
	}
	public static boolean result(int[] numbers, int a, int b) {
		int temp = 0;
		for (int number :numbers) {
			if (number == a) {
				temp += a;
				System.out.println("Data passed is " + temp);
		}
		    if (temp > b) {
		    break;
		    }
		   
		}
	        return temp == b;
	
		
	}
}


