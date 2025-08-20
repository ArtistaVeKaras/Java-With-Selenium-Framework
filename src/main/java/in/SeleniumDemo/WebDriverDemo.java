package in.SeleniumDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class WebDriverDemo {

    public static void main(String[] args) {

        WebDriver wd = null;
        WebDriver driver = new ChromeDriver();
//      TODO: Learn how to implement the selenium Grid
//      ChromeOptions options = new ChromeOptions();

//      Connects to the chromedriver directly. This will launch the browser without the need to use the get method
//      wd = new ChromeDriver(options);

        String url_store1 = "https://demo.nopcommerce.com/";
        String url_store2 = "https://demo.evershop.io/men?od=asc";

        gotoURL(driver, url_store1);

        // Locators
        WebElement emailInputField = driver.findElement(By.className("button-1"));
        WebElement emailInputField2 = driver.findElement(By.id("Email"));
        emailInputField2.sendKeys("nVH9M@example.com");
        findElementByClassName(emailInputField);
        loopThroughWebElements(driver);
        selectElementFromDropdown(driver, url_store2);

        driver.quit();
    }

    // Goto URL and get the title
    public static void gotoURL( WebDriver driver, String url) {
        driver.get(url);
        System.out.println("Title: " + driver.getTitle());
    }

    // Find element by className and Print the value of button submit.
    // We are allowed to extract the value because the className takes the value of a string
    public static void findElementByClassName(WebElement element) {
        String value = element.getAttribute("type");
        System.out.println("The value of the button is: " + value);
    }

    // loop through a List of Web elements on the webpage that contains the input tag
    public static void loopThroughWebElements(WebDriver driver) {
        List<WebElement> l1 = driver.findElements(By.xpath("//input"));
        Iterator<WebElement> i1 = l1.iterator();
        while (i1.hasNext()) {
            System.out.println(i1.next().getAttribute("name"));
        }
    }

    // Select an element from a dropdown
    public static void selectElementFromDropdown(WebDriver driver, String url) {
        driver.get(url);
        WebElement dropdown = driver.findElement(By.className("form-field"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        //This will print the "Price" option from the dropdown menu
        System.out.println("Selected value is: " + select.getFirstSelectedOption().getText());
    }
}