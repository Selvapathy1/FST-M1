package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {
		public static void main(String[] args) {
			
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://training-support.net/webelements/tabs");
		
		System.out.println("page title is " + driver.getTitle());
		
		//find element
		driver.findElement(By.xpath("//button[text()='Open A New Tab']")).click();
		//print the current handle
		System.out.println("current tab handle is : " + driver.getWindowHandle());
		//print the handles of al lthe task
		System.out.println("current tab handle is : " + driver.getWindowHandles());
		//swtich to latest tab
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		for(String handle: driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		System.out.println("current new handle" + driver.getWindowHandle());
		System.out.println("new tab title is : " + driver.getTitle());
		System.out.println("new tab message is : " + driver.findElement(By.cssSelector("h2.text-gray-800")).getText());
		driver.quit();
		}
}
