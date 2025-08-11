package activities;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity18 {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
				
		driver.get("https://training-support.net/webelements/alerts");
		System.out.println("Page Title is : " + driver.getTitle());
		//find element simple
		driver.findElement(By.id("simple")).click();
		
		//switch alertto
		Alert simpleAlert = driver.switchTo().alert();
	    //print alert
		System.out.println("Alert type with straight statement : " + simpleAlert.getText());
		//close the alert
		simpleAlert.accept();
		System.out.println(driver.findElement(By.id("result")).getText());
		driver.quit();
		
	}
}
