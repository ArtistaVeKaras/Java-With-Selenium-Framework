package in.SeleniumDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import in.pages.LoginPage;
import in.pages.example.pages.Essentials;

public class WebDriverDemo {

    public static void main(String[] args) {

        WebDriver wd = null;
        WebDriver driver = new ChromeDriver();

        // Page objects
        LoginPage loginPage = new LoginPage(driver);
        Essentials essentials = new Essentials(driver);

//        loginPage.navigateToLoginPage();
//        essentials.gotoURL(Essentials.url_store1);
//        essentials.findElementByClassName();
//        essentials.loopThroughWebElements(Essentials.url_login, essentials.inputElements);
//        essentials.selectElementFromDropdown();
//        essentials.linkText();
        essentials.testMultipleWindows();

//        driver.quit();

//      TODO: Learn how to implement the selenium Grid
//      ChromeOptions options = new ChromeOptions();

//      Connects to the chromedriver directly. This will launch the browser without the need to use the get method
//      wd = new ChromeDriver(options);

    }
}