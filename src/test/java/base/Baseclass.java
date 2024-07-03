package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Baseclass {
    Properties prop;
    public static WebDriver driver;
    public URL hubUrl;

    public Baseclass() {
        prop = new Properties();
        try (FileInputStream file = new FileInputStream("C:\\Users\\Pritesh\\eclipse-workspace\\EcommerceRestAssured\\data.properties")) {
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return prop;
    }

    public void intialization() throws MalformedURLException {
    	if(prop.getProperty("run").equals("local")) {
    		if(prop.getProperty("browser").equals("chrome")) {
    			driver = new ChromeDriver();
    			System.out.println("Execution on Chrome browser..");
    		}
    		else if(prop.getProperty("browser").equals("firefox")) {
    			driver = new FirefoxDriver();
    			System.out.println("Execution on Firefox browser..");    					
    	}
    		else if(prop.getProperty("browser").equals("edge")) {
    			driver = new EdgeDriver();
    			System.out.println("Execution on IE browser..");    					
    	}
        
    }
    	else if(prop.getProperty("run").equals("cloud")) {
    		hubUrl = new URL("http://localhost:4444/wd/hub");
    		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
    			System.out.println("Execution into Docker Chrome browser..");
                ChromeOptions options = new ChromeOptions();
                driver = new RemoteWebDriver(hubUrl, options);
            } else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
            	System.out.println("Execution into Docker Firefox browser..");
                FirefoxOptions options = new FirefoxOptions();
                driver = new RemoteWebDriver(hubUrl, options);
            }
        
    }
    	driver.get("http://www.amazon.in");
    	driver.manage().window().maximize();
}
    public void closeBrowser() {
    	driver.quit();
    }
}
