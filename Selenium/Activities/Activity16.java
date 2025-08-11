package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {
	public static void main(String[] args) {
		//create a driver object
		WebDriver driver = new FirefoxDriver();
		//open the page
		driver.get("https://training-support.net/webelements/selects");
		//verify the page title
		System.out.println("Page title is: " +driver.getTitle());
		
		WebElement select1 =driver.findElement(By.cssSelector("select.h-10"));
		Select dropdown = new Select(select1);
		
		//select second option
		dropdown.selectByVisibleText("One");
		
		// third option by index
		dropdown.selectByIndex(2);
		//selct foruth element
		dropdown.selectByValue("three");
		
		//get all option to print on console
		for(WebElement option: dropdown.getOptions()) {
			System.out.println(option.getText());
		}
		driver.quit();
		}
	}

	