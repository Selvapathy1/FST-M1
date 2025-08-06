package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
	public static void main(String[] args) {
		//create a driver object
		WebDriver driver = new FirefoxDriver();
		//open the page
		driver.get("https://training-support.net");
		//verify the page title
		System.out.println("Page title is: " +driver.getTitle());
		
		//interaction 
		//find the title of the page
		driver.findElement(By.linkText("About Us")).click();
		
		//new page title
		System.out.println("New Page title is: " +driver.getTitle());
		//close the browser
		
		driver.quit();//close entire browser active tab 
	}

}
