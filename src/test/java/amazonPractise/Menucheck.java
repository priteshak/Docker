package amazonPractise;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Menucheck {

	@Test
    public static void mainn() {
        
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.amazon.in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        List<WebElement> menuList = driver.findElements(By.xpath("(//a[@class='nav-a'])[2] | //a[@class='nav-a  ']"));
        List<String> actualElements = new ArrayList<>();
        
        for (WebElement element : menuList) {
            actualElements.add(element.getText().trim());
        }
        
        List<String> expectedElements = Arrays.asList(
            "Start here.",
            "Fresh",
            "Amazon miniTV",
            "Sell",
            "Best Sellers",
            "Mobiles",
            "Today's Deals",
            "Fashion",
            "Electronics",
            "Prime",
            "Customer Service",
            "New Releases",
            "Home & Kitchen",
            "Amazon Pay",
            "Computers",
            "Books",
            "Car & Motorbike",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "");
        if (actualElements.equals(expectedElements)) {
            System.out.println("The menu list matches the expected elements.");
            System.out.println("Actual: " + actualElements);
            System.out.println("Expected: " + expectedElements);
        } else {
            System.out.println("The menu list does not match the expected elements.");
            System.out.println("Actual: " + actualElements);
            System.out.println("Expected: " + expectedElements);
        }
        
        driver.quit();        
    }
}
