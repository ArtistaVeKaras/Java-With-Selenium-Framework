package in.SeleniumDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class WebDriverDemo {

    public static void main(String[] args) {

        WebDriver wd = null;
//      TODO: Learn how to implement the selenium Grid
//        ChromeOptions options = new ChromeOptions();

//  Connects to the chromedriver directly. This will launch the browser without the need to use the get method
//         wd = new ChromeDriver(options);

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/login");
        driver.findElement(By.id("Email")).sendKeys("nVH9M@example.com");

        // Find element by classNamePrint the value of button submit.
        // We are allowed to extract the value because the className takes the value of a string
        String value = driver.findElement(By.className("button-1")).getAttribute("type");
        System.out.println("The value of the button is: " + value);

        // loop through a List of Web elements on the webpage
        List<WebElement> l1 = driver.findElements(By.xpath("//input"));
        Iterator<WebElement> i1 = l1.iterator();
        while (i1.hasNext()) {
            System.out.println(i1.next().getAttribute("name"));
        }
        driver.quit();

    }
}