package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGAnnotationTest {

    WebDriver driver = new ChromeDriver();

    // URL
    String url = "https://demo.evershop.io/account/login";

   // Locator
    By email = By.name("email");
    By password = By.name("password");
    By login = By.cssSelector("button[type='submit'] span");

    @Parameters({"browser", "environment"})
    @BeforeTest
    public void setUp(String browser, String env){
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        System.out.println("Running tests on: " + browser + " and environment: " + env);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterTest
    public void tearDown(){
            if (driver != null) {
                driver.quit();
            }
    }

    @Test(testName ="Verify Login success", groups = {"positive, smoke"})
    public void loginTest(){
        System.out.println("Verify Login success");
        driver.findElement(email).sendKeys("test@example.com");
        driver.findElement(password).sendKeys("test");
        driver.findElement(login).click();
    }

    @Test(testName ="Verify Login unsuccess", groups = {"negative, regression"})
    public void loginTest2(){
        System.out.println("Verify Login unsuccess");
        driver.findElement(email).sendKeys("test@example.com");
        driver.findElement(password).sendKeys("");
        driver.findElement(login).click();
    }
    @Test(groups = "smoke, login", priority = 1)
    public void testValidLogin() {
        System.out.println("Login Test 1");
        // Test valid login
    }

    @Test(groups = "regression, login", priority = 2)
    public void testLoginWithInvalidCredentials() {
        System.out.println("Login Test 2");
        // Test invalid login
    }

    @Test(groups = "smoke, registration", priority = 3)
    public void testUserRegistration() {
        System.out.println("Login Test 3");
        // Test user registration
    }
}
