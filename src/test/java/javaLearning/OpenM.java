package javaLearning;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenM {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.t-mobile.com/tablets");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println("Printing");
		System.out.println(driver.findElement(By.xpath("//legend[contains(text(), 'Deals')]/following-sibling::div//span[contains(@class, 'filter-display-name') and contains(text(), 'New')]/ancestor::mat-checkbox//input[@type='checkbox']")).getText());
//		methodName("Deals", "New", "Special offer");
//		methodName("Brands", "Apple");
		methodName("Brands", "All");
		methodName("Deals", "All");
		/* Scenarios developed and tested:
		 * 1. Single main filter with values
		 * 2. More than one main filter with values
		 * 3. Single main filter with all the values
		 * 4. More than one main filter with all the values
		 * 
		 *  */

	}

	private static void methodName(String... stringNames) throws InterruptedException {
		List<String> stringList = new ArrayList<>();
		for (String name : stringNames) {
			stringList.add(name);
		}
		System.out.println(stringList);
		String mainFilterName = stringList.get(0);
		System.out.println(mainFilterName);

//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.t-mobile.com/tablets");
//		driver.manage().window().maximize();
//		Thread.sleep(2000);

		int flag = 0;
		String selectAllFilterData = stringList.get(1);
		if (selectAllFilterData.equals("All")) {
			driver.findElement(By.xpath("//legend[contains(text(), '" + mainFilterName + "')]")).click();
			List<WebElement> allCheckbox = driver
					.findElements(By.xpath("//span//span[contains(text(), '') and @class= 'filter-display-name']"));
			System.out.println("Count of checkboxes :" + allCheckbox.size());
			for (int k = 0; k < allCheckbox.size(); k++) {
				String checkboxElement = allCheckbox.get(k).getText();
				driver.findElement(By.xpath("//span//span[contains(text(), '" + checkboxElement + "') and @class= 'filter-display-name']"))
						.click();
				flag++;
				if (flag == allCheckbox.size()) {
					System.out.println(flag);
					break;
				}
			}
		}

		else {
			driver.findElement(By.xpath("//legend[contains(text(), '" + mainFilterName + "')]")).click();
			Thread.sleep(2000);
			for (int i = 1; i < stringList.size(); i++) {
				System.out.println(stringList.get(i));
				driver.findElement(By.xpath("//span//span[contains(text(), '" + stringList.get(i)
						+ "') and @class= 'filter-display-name']")).click();
			}
			Thread.sleep(2000);

		}
		//driver.quit();
	}

}
