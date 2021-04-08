package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class ForthPageCheckout {
	
	public ForthPageCheckout() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath = "")
	public WebElement bookPriceCheckOut;
	
	
}
