package activities;

import java.util.Arrays;

public class Activity4 {
	static void ascendSort(int array[]) {
		// finding the number of elements using length inbuilt function
		int size = array.length, i; // i declared not initialize
		
		for(i = 1; i<size; i++) {
			int key = array[i];
			System.out.println(" Array i values is : " + array[i]);
			int j = i - 1;
			
			while (j >= 0 && key < array[j]) {
				array[j + 1] = array[j];
				--j;
			}
			array[j + 1] = key;
			System.out.println(" key vaue is :" + key);
		}
	}
	

	
	public static void main(String[] args) {
		// initialize the array
		
	  int [] samplearr = {10, 5, 8, 3 ,1};
	  ascendSort(samplearr);
	  System.out.println("Sorted Array in Ascending Order: ");
      System.out.println(Arrays.toString(samplearr));
	}

}
