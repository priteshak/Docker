package Individual_Test_Cases;

import java.awt.BufferCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class Seleniumgrid {

	public static void main(String[] args) throws MalformedURLException {

		// Set the Hub URL
		String hubUrl = "http://localhost:4444/wd/hub";

		// Specify browser capabilities (in this case, Chrome)

//		FirefoxOptions options = new FirefoxOptions();
//		options.setCapability("browserName", "firefox");
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability("browserName", "chrome");
		
//		EdgeOptions options = new EdgeOptions();
//		options.setCapability("browserName", "MicrosoftEdge");
		

		// Create a RemoteWebDriver instance and connect to the Selenium Grid
		WebDriver driver = new RemoteWebDriver(new URL(hubUrl), options);
//		WebDriver driver = new ChromeDriver();

		// Your Selenium script here
		driver.get("https://www.google.com/");
		System.out.println("Page title: " + driver.getTitle());

		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName();
	    System.out.println(browserName);
		
		// Close the browser
		driver.quit();
	}
}
