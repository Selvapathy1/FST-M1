package Activities;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.reporters.TestHTMLReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;
    ExtentReports extent;
    ExtentSparkReporter htmlReporter;
    ExtentTest test;

    @BeforeClass
    public void setUp() {
    			// Create an instance of ExtentReports
    			extent = new ExtentReports();
    			// Create a spark reporter with the given file name
    			htmlReporter = new ExtentSparkReporter("extentReport.html");
    			// Attach the reporter to the ExtentReports instance
    			extent.attachReporter(htmlReporter);
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

    @Test(priority =2,dataProvider = "InvalidCredentials")
         
    public void invalidloginTest(String username, String password) throws IOException {
    	test = extent.createTest("Invalid Login Test with username: " + username + " and password: " + password);
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
        test.log(Status.INFO, "Invalid Login Test with username: " + username + " and password: " + password + " Passed");
        //Take screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File SourceFile = ts.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
        File DestFile = new File("C:\\Users\\SelvapathyKalaimanna\\Desktop\\FST\\sample.png");
        //Copy file at destination
        FileHandler.copy(SourceFile, DestFile); 
        test.addScreenCaptureFromPath("C:\\Users\\SelvapathyKalaimanna\\Desktop\\FST\\sample.png");
        
    }
    
    @Test(priority = 3)
    public void validloginTest() {
    	test = extent.createTest("Valid Login Test");
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
        test.log(Status.INFO, "Valid Login Test Passed");
    }
    
    
    
    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
        extent.flush();
    }
}