# TestNG Best Practices with Examples

## 1. Organizing Tests with Groups

Group related tests to run them selectively:

```java
public class LoginTests {
    
    @Test(groups = {"smoke", "login"})
    public void testValidLogin() {
        // Test valid login
    }
    
    @Test(groups = {"regression", "login"})
    public void testLoginWithInvalidCredentials() {
        // Test invalid login
    }
    
    @Test(groups = {"smoke", "registration"})
    public void testUserRegistration() {
        // Test user registration
    }
}
```

Run specific groups from testng.xml:

```xml
<test name="Smoke Tests">
    <groups>
        <run>
            <include name="smoke"/>
        </run>
    </groups>
    <classes>
        <class name="com.tests.LoginTests"/>
    </classes>
</test>
```

## 2. Data-Driven Testing with @DataProvider

```java
public class DataDrivenTests {
    
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"user1@example.com", "password123"},
            {"user2@example.com", "password456"},
            {"user3@example.com", "password789"}
        };
    }
    
    @Test(dataProvider = "loginData")
    public void testLoginWithMultipleUsers(String username, String password) {
        // Test login with different credentials
        System.out.println("Testing with user: " + username);
        // Assert login success/failure
    }
}
```

## 3. Parallel Test Execution

Configure in testng.xml:

```xml
<suite name="Parallel Test Suite" parallel="methods" thread-count="3">
    <test name="Parallel Tests">
        <classes>
            <class name="com.tests.ParallelTests"/>
        </classes>
    </test>
</suite>
```

Parallel execution options:
- `methods`: Runs test methods in separate threads
- `tests`: Runs test tags in separate threads
- `classes`: Runs test classes in separate threads
- `instances`: Runs test instances in separate threads

## 4. Managing Test Dependencies

```java
public class DependenciesTest {
    
    @Test
    public void login() {
        System.out.println("Logging in...");
        // Login implementation
    }
    
    @Test(dependsOnMethods = {"login"})
    public void viewDashboard() {
        System.out.println("Viewing dashboard...");
        // Dashboard test
    }
    
    @Test(dependsOnGroups = {"smoke"})
    public void criticalPathTest() {
        // This test will run after all tests in 'smoke' group complete
    }
    
    @Test(dependsOnMethods = {"login"}, alwaysRun = true)
    public void alwaysRunExample() {
        // This will run even if login fails
    }
}
```

## 5. Implementing Custom Listeners

Create a custom listener:

```java
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener {
    
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting test: " + result.getName());
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        // Take screenshot or log additional info
    }
}
```

Register the listener in testng.xml:

```xml
<listeners>
    <listener class-name="com.listeners.CustomTestListener"/>
</listeners>
```

## 6. Effective Assertions

```java
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionExamples {
    
    @Test
    public void testAssertions() {
        // Basic assertions
        Assert.assertEquals(2+2, 4, "Math should work correctly");
        Assert.assertNotEquals(1, 2, "These should not be equal");
        
        // Boolean conditions
        boolean isUserLoggedIn = true;
        Assert.assertTrue(isUserLoggedIn, "User should be logged in");
        
        // Null checks
        String name = null;
        Assert.assertNull(name, "Name should be null");
        
        // Collection assertions
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Assert.assertEquals(names.size(), 3, "Should have 3 names");
        Assert.assertTrue(names.contains("Alice"), "Should contain Alice");
        
        // Soft assertions (collects multiple failures)
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(1, 2, "This will fail but continue");
        softAssert.assertTrue(false, "This will also fail");
        softAssert.assertAll(); // Reports all failures
    }
}
```

## 7. Test Configuration with @Parameters

```java
public class ParameterizedTest {
    
    @Parameters({"browser", "environment"})
    @BeforeTest
    public void setup(String browser, String env) {
        System.out.println("Running tests on " + browser + " in " + env + " environment");
        // Initialize WebDriver based on browser parameter
    }
    
    @Test
    public void testWithConfig() {
        // Test implementation
    }
}
```

Define parameters in testng.xml:

```xml
<suite name="Parameter Test">
    <parameter name="browser" value="chrome"/>
    <parameter name="environment" value="staging"/>
    <test name="Parameter Test">
        <classes>
            <class name="com.tests.ParameterizedTest"/>
        </classes>
    </test>
</suite>
```

## 8. Timeout for Tests

```java
@Test(timeOut = 5000) // Test will fail if it takes longer than 5 seconds
public void testWithTimeout() {
    // Long-running test
    Thread.sleep(10000); // This will cause the test to fail
}
```

## 9. Skipping Tests

```java
public class SkipTests {
    
    @Test(enabled = false)
    public void skippedTest() {
        // This test will be skipped
    }
    
    @Test
    public void conditionalSkip() {
        boolean isFeatureEnabled = false;
        
        // Skip test at runtime
        if (!isFeatureEnabled) {
            throw new SkipException("Feature is not enabled, skipping test");
        }
        
        // Test implementation
    }
}
```

## 10. Test Retry Logic

Create a retry analyzer:

```java
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int MAX_RETRY_COUNT = 3;
    
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            return true;
        }
        return false;
    }
}
```

Use with test methods:

```java
@Test(retryAnalyzer = RetryAnalyzer.class)
public void flakyTest() {
    // Test that might fail occasionally
}
```

These examples cover the most common TestNG best practices and can be adapted to fit your specific testing needs. Remember to choose the approaches that best fit your project's requirements and maintainability goals.
