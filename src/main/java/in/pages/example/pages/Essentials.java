package in.pages.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Essentials extends BasePage {

    // Page URL
    public static final String url_store1 = "https://demo.nopcommerce.com/";
    public static final String url_login =   "https://demo.nopcommerce.com/login?returnUrl=%2F";
    private static final String url_store2 = "https://demo.evershop.io/men?od=asc";

    // Locators
    @FindBy(className = "button-1") private WebElement buttonSubmit;
    @FindBy(xpath = "//input") public List<WebElement> inputElements;
    @FindBy(className = "form-field") private WebElement dropdown;
    @FindBy(linkText = "Strutter shoes") private WebElement linkText;
    @FindBy(className = "product-single-name") private WebElement productSingleName;

    public Essentials(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * This method navigates to a specified URL and retrieves the page title.
     */
    // Page actions
    public void gotoURL(String url) {
        driver.get(url);
        System.out.println("Title: " + driver.getTitle());
    }

    /**
     * This method finds an element by its class name and prints the value of the button submit.
     * The class name is used to locate the element because it can be a string.
     */
    public void findElementByClassName() {
        String value = buttonSubmit.getAttribute("type");
        System.out.println("The value of the button is: " + value);
    }

    /**
     * This method iterates through a list of WebElements on the webpage that contains the input tag.
     * It retrieves the value of the name attribute for each element and prints it to the console.
     */
    public void loopThroughWebElements(String url, List<WebElement> elements) {
        driver.get(url_login);
        Iterator<WebElement> i1 = elements.iterator();
        while (i1.hasNext()) {
            System.out.println(i1.next().getAttribute("name"));
        }
    }

    /**
     * This method selects an element from a dropdown menu by its index.
     * It first navigates to the specified URL, finds the dropdown element by its class name,
     * creates a Select object from the dropdown element, and selects the element at index 1.
     * Finally, it retrieves the text of the selected element and prints it to the console.
     */
    public void selectElementFromDropdown() {
        driver.get(url_store2);
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        //This will print the index of the selected element which in this case is "Price"
        System.out.println("Selected value is: " + select.getFirstSelectedOption().getText());
    }

    /**
     * This method navigates to a specified URL, clicks on a link with the text
     * and retrieves the text of the first element with the class name "product-single-name".
     */
    public void linkText() {
        driver.get(url_store2);
        linkText.click();
        System.out.println("The text contains the following text: " + productSingleName.getText());
    }

    /**
     * This method demonstrates how to open multiple windows in a browser using Selenium.
     * It opens the first window with the URL "https://example.com" and then opens a second window with the URL "https://google.com".
     */
    public void testMultipleWindows() {
        // Open first window
        driver.get("https://example.com");

        // Open second window
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com');");

        // Open a third window
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com');");

       // Get window handles
       Set<String> windowHandles = driver.getWindowHandles();
       String firstWindow = driver.getWindowHandle();

       System.out.println(windowHandles.size());
       System.out.println(windowHandles);

        // Switch to second window and close it. In this instance, it will close the second window (i.e. Google)
        for (String handle : windowHandles) {
            if (!handle.equals(firstWindow)) {
                driver.switchTo().window(handle);
                driver.close(); // Close only the second window
                break;
            }
        }

        // Switch back to first window
        driver.switchTo().window(firstWindow);
        // Continue testing with first window...

    }
}
