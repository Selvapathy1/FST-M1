package activities;

public class Activity1 {

	public static void main(String[] args) {
		// Create Object of car
		Car honda = new Car("Black","Automtic",2020);
		
		//print details of car
		honda.displayCharacteristics();
		//Move the car
		honda.accelerate();
		//Stop the car
		honda.brake();
		
	}

}
