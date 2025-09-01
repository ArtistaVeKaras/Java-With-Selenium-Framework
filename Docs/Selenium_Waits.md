# Selenium Waits

In Selenium, waits are used to handle synchronization issues between the test execution and the application's response time. There are three main types of waits in Selenium:

## 1. Implicit Wait
Implicit Wait tells the WebDriver to wait for a certain amount of time before throwing a `NoSuchElementException`.

```java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        
        // Set implicit wait to 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.get("https://example.com");
        
        // WebDriver will wait up to 10 seconds for the element to be present
        // before throwing NoSuchElementException
        // WebElement element = driver.findElement(By.id("someElement"));
        
        driver.quit();
    }
}
```

## 2. Explicit Wait
Explicit Wait is used to wait for a specific condition to occur before proceeding further in the code.

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ExplicitWaitExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");
        
        // Create WebDriverWait with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Wait until element is clickable
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("someButton")));
        element.click();
        
        driver.quit();
    }
}
```

## 3. Fluent Wait
Fluent Wait is used to define the maximum amount of time to wait for a condition, as well as the frequency with which to check the condition.

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class FluentWaitExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");
        
        // Define FluentWait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(30))     // Maximum time to wait
            .pollingEvery(Duration.ofSeconds(5))     // Check every 5 seconds
            .ignoring(NoSuchElementException.class); // Ignore this exception
        
        // Usage
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("dynamicElement"));
            }
        });
        
        element.click();
        driver.quit();
    }
}
```

## Key Differences

| Wait Type         | Parameters | Polling | Exception Handling | Use Case |
|-------------------|------------|---------|-------------------|----------|
| **Implicit Wait** | Timeout only | No | Only NoSuchElement | Global wait for all elements |
| **Explicit Wait** | Timeout, ExpectedCondition | Configurable | Configurable | Specific conditions for elements |
| **Fluent Wait**   | Timeout, Polling, Ignore Exceptions | Configurable | Configurable | Complex wait scenarios |

## Best Practices
- Use Explicit Wait for specific conditions
- Avoid mixing Implicit and Explicit Waits
- Use Fluent Wait for complex scenarios requiring custom polling and exception handling
- Always use meaningful timeout values based on your application's response time
