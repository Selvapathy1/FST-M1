package activities;

public class Car {
	//properties
	String color;
	String transmission;
	int make;
	int tyres = 4;
	int doors = 4;
	
	//constructor
	public Car(String color, String transmission, int make) {
		this.color = color;
		this.transmission = transmission;
		this.make = make;	
	}
	//Methods/Functions
		public void displayCharacteristics() {
			//print statement of the class
			System.out.println("The color is : " + color);
			System.out.println("The transmission type is : " + transmission);
			System.out.println("The car was made in : " + make);
			System.out.println("It has : " + doors + " doors");
			System.out.println("It has : " + tyres + " tyres");
	
	}
		public void accelerate() {
			System.out.println("Car is moving forward");
		}
		public void brake() {
			System.out.println("Car has stopped");
		}
	
}
