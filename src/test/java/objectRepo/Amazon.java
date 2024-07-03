package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Baseclass;

public class Amazon extends Baseclass {

	@FindBy(xpath = "//a[@id='nav-hamburger-menu']")
	WebElement allProducts;
	
	@FindBy(xpath = "//div[contains(text(),'Trending')]")
	WebElement checkAllProductsHeader;

	public Amazon() {
		PageFactory.initElements(driver, this);
	}

	public void clickAllProductLink() {
		allProducts.click();
	}
	
	public String checkAllProductLink() {
		return checkAllProductsHeader.getText();
	}


}
