package Activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Initialize driver
        driver = new FirefoxDriver();
        // Initialize wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Open the page
        driver.get("https://training-support.net/webelements/login-form");
    }
    
    @Test(priority = 1)
	public void pageTitleTest() {
    	assertEquals(driver.getTitle(), "Selenium: Login Form");
    }

    @DataProvider(name = "InvalidCredentials")
    public static Object[][] creds() {
        return new Object[][] { 
            { "admin1", "incorrectpassword"},
            {"incorrectAdmin", "password" },
            { "admin", "#%2@49$$#()"},
            {"DELETE TABLE USERS", "password" }
        };
    }

    @Test(dataProvider = "InvalidCredentials")
    public void invalidloginTest(String username, String password) {
        // Find the input fields and the login button
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Submit']"));

        // Clear the input fields
        usernameField.clear();
        passwordField.clear();
        
        // Enter the username and password, then click the login button
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        // Wait for the error message to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subheading")));
        // Assert login message
        String loginMessage = driver.findElement(By.id("subheading")).getText();
        assertEquals(loginMessage, "Invalid credentials" );
    }
    
    @Test(priority = 3)
    public void validloginTest() {
        // Find the input fields and the login button
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Submit']"));

        // Clear the input fields
        usernameField.clear();
        passwordField.clear();
        
        // Enter the username and password, then click the login button
        usernameField.sendKeys("admin");
        passwordField.sendKeys("password");
        loginButton.click();
        // Wait for the login message to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.text-gray-800")));
        // Assert login message
        String loginMessage = driver.findElement(By.cssSelector("h2.text-gray-800")).getText();
        assertEquals(loginMessage, "Welcome Back, Admin!" );
    }
    
    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}