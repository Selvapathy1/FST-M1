package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {
	public static void main(String[] args) {
		//create a driver object
		WebDriver driver = new FirefoxDriver();
		//open the page
		driver.get("https://training-support.net/webelements/selects");
		//verify the page title
		System.out.println("Page title is: " +driver.getTitle());
		
		WebElement selectElement =driver.findElement(By.cssSelector("select.h-80"));
		Select multiSelect = new Select(selectElement);
		
		//select HTML using visible test option
		multiSelect.selectByVisibleText("HTML");
		
		// select 4th,5th and 6th option
		for (int i=3; i<=5; i++) {
			multiSelect.selectByIndex(i);
			
		}
		
		//selct node using value attribute
		multiSelect.selectByValue("nodejs");
		
		//print the select options
		List<WebElement> selectedoptions =multiSelect.getAllSelectedOptions();
				System.out.println("Selected options are : ");
				for (WebElement option :selectedoptions) {
					System.out.println(option.getText());
				}
		//deselect 5th index
		multiSelect.deselectByIndex(4);
		
		selectedoptions =multiSelect.getAllSelectedOptions();
		System.out.println("Selected options are : ");
		for (WebElement option :selectedoptions) {
			System.out.println(option.getText());
		}
		driver.quit();
		}
	}

	