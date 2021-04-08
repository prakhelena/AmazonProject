package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class SecondPage {
	
	public SecondPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath = "//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/span/a/div/img")
	public WebElement book;
	
	@FindBy (xpath = "//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[4]/div[2]/a/span[1]/span[2]/span[2]")
	public WebElement firstHalfOfPrice;
	
	@FindBy (xpath = "//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[4]/div[2]/a/span[1]/span[2]/span[3]")
	public WebElement secondHalfOfPrice;
	
	
	
	
}
