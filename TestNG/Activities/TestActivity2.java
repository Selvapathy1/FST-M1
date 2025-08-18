package Activities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class TestActivity2 {
		//declare the driver & wait
		WebDriver driver;
		WebDriverWait wait;
		
		@BeforeClass
		public void setup() {
			driver = new FirefoxDriver();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
		}
		
}
