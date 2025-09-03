package in.BroswerInterface;

public class Selenium {

    public static void main(String[] args) {

        String browserName = "Firefox";
        Browser browser = null;

        if (browserName.equals("Chrome")) {
            browser = new ChromeBrowser();
        } else if (browserName.equals("Firefox")) {
            browser = new FirefoxBrowser();
        } else {
            throw new IllegalArgumentException("Invalid browser name: " + browserName);
        }

            browser.console();
            browser.userInterface();
    }
}