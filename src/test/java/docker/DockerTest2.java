package docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DockerTest2 {
    public WebDriver driver;

    @Parameters("browser")
    @Test
    public void openAmazon(String browser) throws MalformedURLException {
        URL hubUrl = new URL("http://localhost:4444/wd/hub");

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            driver = new RemoteWebDriver(hubUrl, options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            driver = new RemoteWebDriver(hubUrl, options);
        }

        driver.get("http://www.amazon.in");
        System.out.println("Title of the page is: " + driver.getTitle());
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = caps.getBrowserName();
        System.out.println("Browser name is: " + browserName);
        driver.quit();
    }
}
