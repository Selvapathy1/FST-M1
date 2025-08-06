package activities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) {
		 	WebDriver driver = new FirefoxDriver();
		 	// Open the page
	        driver.get("https://training-support.net/webelements/login-form");
	        // Print the title of the page
	        System.out.println("Page title: " + driver.getTitle());
	        //find the user name field and enter user name
	        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
	        // find the password field and enter password
	        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
	        // find the login button and click
	        driver.findElement(By.xpath("//button[text()='Submit']")).click();
	      
	        System.out.println("New Page title: " + driver.getTitle());
	        String message = driver.findElement(By.xpath("//h1[contains(text(),'success')]")).getText();
	        System.out.println(message);
	        
	        driver.quit();
	        
	}

}
