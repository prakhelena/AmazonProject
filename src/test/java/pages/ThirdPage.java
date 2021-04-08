package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class ThirdPage {
	
	public ThirdPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath = "//*[@id=\"newBuyBoxPrice\"]")
	public WebElement bookPriceThirdPage;
	
//	@FindBy (xpath = "//*[@id="add-to-cart-button"]")
//	public WebElement ;
	
	@FindBy (id = "add-to-cart-button")
	public WebElement addToCart;
	
	@FindBy (id = "hlb-ptc-btn-native")
	public WebElement proceedToCheckOut;
	
	@FindBy (xpath = "//*[@id=\"hlb-subcart\"]/div[1]/span/span[2]")
	public WebElement bookPriceBeforeCheckOut;

	
	
	
	
}
