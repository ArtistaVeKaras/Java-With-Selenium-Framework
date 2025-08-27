package in.pages.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Essentials extends BasePage {

    // Page URL
    public static final String url_store1 = "https://demo.nopcommerce.com/";
    public static final String url_login =   "https://demo.nopcommerce.com/login?returnUrl=%2F";
    private static final String url_store2 = "https://demo.evershop.io/men?od=asc";
    private static final String iframeUrl = "https://selectorshub.com/iframe-scenario/";
    private static final String showdownUrl = "http://127.0.0.1:5501/ShadomDOMExample.html";

    // Locators
    @FindBy(className = "button-1") private WebElement buttonSubmit;
    @FindBy(xpath = "//input") public List<WebElement> inputElements;
    @FindBy(className = "form-field") private WebElement dropdown;
    @FindBy(linkText = "Strutter shoes") private WebElement linkText;
    @FindBy(className = "product-single-name") private WebElement productSingleName;
    @FindBy(id = "inp_val") private WebElement iframeInput;

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
        driver.get(url);
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
    
    /**
     * This method demonstrates how to interact with elements within an iframe.
     * It first navigates to a webpage that contains an iframe, switches to the iframe,
     * finds an element by its ID, clears its existing text, and sends new text to it.
     *
     * @see <a href="https://selectorshub.com/iframe-scenario/">Iframe Scenario</a>
     */
    public void iframeTest() {
        driver.get(iframeUrl);

       // Switch to iframe by indexing
//       WebElement iframeInput = driver.switchTo().frame(0).findElement(By.id("inp_val"));
//       iframeInput.clear();
//       iframeInput.sendKeys("Hello");

       // Switch to iframe by WebElement
       WebElement iframe = driver.findElement(By.cssSelector("#pact1"));
       driver.switchTo().frame(iframe);
       WebElement usernameField = driver.findElement(By.cssSelector("#inp_val"));
        usernameField.sendKeys("Hello");
    }

    //TODO: find  a webpage that has a shadow DOM and test it
    public void showdowDOMTest(){
        driver.get(showdownUrl);
    }

    /**
     * This method demonstrates how to use an implicit wait to wait for an element to appear on a webpage.
     * It first sets the implicit wait timeout to 60 seconds and then navigates to a webpage that contains a login form.
     * After navigating to the webpage, the implicit wait timeout will cause the driver to wait for up to 60 seconds
     * for the email field to appear before throwing a NoSuchElementException.
     *
     * @see <a href="https://www.selenium.dev/documentation/en/webdriver/waits/#implicit-wait">Implicit Wait</a>
     */
    public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://demo.evershop.io/account/login");
    }

    /**
     * This method demonstrates how to use an explicit wait to wait for an element to become visible.
     * It first navigates to a webpage that contains a login form, waits for the email field to become visible,
     * and then enters a test email address into the field.
     *
     * @see <a href="https://www.selenium.dev/documentation/en/webdriver/page_loading_strategies/">Page Loading Strategies</a>
     */
    public void explicitWait() {
        driver.get("https://demo.evershop.io/account/login");

        // Create a WebDriverWait object with a timeout of 30 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        element.sendKeys("test@example.com");
    }
}
