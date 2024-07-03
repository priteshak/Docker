package test;

import java.net.MalformedURLException;
import java.sql.Driver;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Baseclass;
import org.apache.logging.log4j.Logger;
import objectRepo.Amazon;

public class Flowtest extends Baseclass {
	
    private static final Logger logger = LogManager.getLogger(Flowtest.class);
	public Amazon amazon;
	
	public Flowtest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws MalformedURLException {
        logger.info("Launching browser");
		intialization();
		amazon = new Amazon();
	}
	
	@Test(priority = 1,enabled = true)
	public void firstTestMethod() {
		String title = driver.getTitle();
		logger.info("Page title is : "+title);
	}
	
	@Test(priority = 2,enabled = true)
	public void secondTestMethod() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean imageCheck = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();  
		Assert.assertTrue(imageCheck);
		logger.info("Image is present or not? "+imageCheck);
	}
	
	@Test(priority = 3)
	public void thirdTestMethod() throws InterruptedException {
		amazon.clickAllProductLink();
		logger.info("Clicking on all product links");
		Thread.sleep(7000);
		String checkValue = amazon.checkAllProductLink();
		Assert.assertEquals(checkValue, "Trending");
		logger.info("Actual value is : "+checkValue);
	}
	
	@Test(priority = 4)
	public void falseComparision() {
		Assert.assertEquals(true, true);
		logger.info("Fourth Test Executing..");
	}
	
	@AfterMethod
	public void tearDown() {
        logger.info("Closing browser");
		closeBrowser();
	}

}
