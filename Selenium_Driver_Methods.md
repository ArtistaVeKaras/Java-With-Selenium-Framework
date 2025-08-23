# Selenium WebDriver: quit() vs close()

## Overview
Two essential WebDriver methods for managing browser sessions are `driver.quit()` and `driver.close()`. While they might seem similar, they serve different purposes.

## driver.close()
- **Action**: Closes the current browser window or tab
- **Session**: Keeps the WebDriver session active
- **Use Case**: When you want to close the current window but continue testing with other open windows
- **Example**:
  ```java
  // Open multiple windows
  driver.get("https://example.com");
  ((JavascriptExecutor) driver).executeScript("window.open('https://google.com');");
  
  // Close the current window (Google)
  driver.close();
  
  // Switch back to the first window (Example.com)
  String firstWindow = driver.getWindowHandles().iterator().next();
  driver.switchTo().window(firstWindow);
  ```

## driver.quit()
- **Action**: Closes all browser windows and ends the WebDriver session
- **Session**: Terminates the WebDriver session completely
- **Use Case**: When you're done with all testing and want to clean up resources
- **Example**:
  ```java
  @AfterTest
  public void tearDown() {
      // This will close all browser windows and end the session
      if (driver != null) {
          driver.quit();
      }
  }
  ```

## Key Differences
| Feature          | close() | quit() |
|-----------------|---------|--------|
| Closes current window | ✅ | ✅ |
| Closes all windows | ❌ | ✅ |
| Ends WebDriver session | ❌ | ✅ |
| Frees system resources | ❌ | ✅ |
| Closes browser process | ❌ | ✅ |

## Best Practices
1. Always use `driver.quit()` in your test teardown to ensure all resources are properly released
2. Use `driver.close()` only when you specifically need to close the current window but continue testing with other windows
3. Never mix both methods in the same test case unless you have a specific reason
4. Always set `driver = null` after `quit()` to ensure the object is garbage collected

## Real-world Example
```java
public class WindowHandlingTest {
    WebDriver driver;
    
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
    }
    
    @Test
    public void testMultipleWindows() {
        // Open first window
        driver.get("https://example.com");
        
        // Open second window
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com');");
        
        // Get window handles
        Set<String> handles = driver.getWindowHandles();
        String firstWindow = handles.iterator().next();
        
        // Switch to second window and close it
        for (String handle : handles) {
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
    
    @AfterTest
    public void tearDown() {
        // Properly close everything when done
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
```

## Common Pitfalls
1. **Memory Leaks**: Forgetting to call `quit()` can leave browser processes running
2. **NoSuchSessionException**: Calling methods after `quit()` will throw this exception
3. **Multiple Windows**: Using `close()` when multiple windows are open requires proper window handling
4. **Parallel Testing**: Always ensure each test has its own WebDriver instance and properly quits it

Remember: When in doubt, `driver.quit()` is the safer choice as it ensures all resources are properly cleaned up.
