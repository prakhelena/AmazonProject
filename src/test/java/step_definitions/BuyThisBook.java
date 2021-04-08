package step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.Keys;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ForthPageCheckout;
import pages.SecondPage;
import pages.ThirdPage;
import pages.VerificationPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class BuyThisBook {
	String bookPriceSecondPage;
	
	//1. Visit amazon.com Page
	@Given("The user is on the homepage")
	public void theUserIsOnTheHomepage() {
		 Driver.getDriver().get(ConfigReader.getProperty("url"));
		    BrowserUtils.waitForPageToLoad(5);
	}

	//2. Search for Book 'qa testing for beginners'
	@When("The user enters book name {string} and press enter")
	public void theUserEntersBookNameAndPressEnter(String string) {
	    VerificationPage vp = new VerificationPage();
	    vp.searchTextBox.sendKeys(string, Keys.ENTER);
			}

	//3. Click on 1st item in the listed results.
	@When("The user clicks on 1st item in the listed results")
	public void theUserClicksOn1stItemInTheListedResults() {
	  SecondPage sp = new SecondPage();

	  String price1 = sp.firstHalfOfPrice.getText();
	  String price2 = sp.secondHalfOfPrice.getText();
	  bookPriceSecondPage = price1 + price2;
			  
	    sp.book.click();
	}

	//4. Before Click on add to cart Add to Cart asset price from Step3. 
	@Then("The user should verify the price for the chosen item")
	public void theUserShouldVerifyThePriceForTheChosenItem() {
		ThirdPage tp = new ThirdPage();
				
	   String bookPriceThirdPage = tp.bookPriceThirdPage.getText();
	   String bookPriceThirdPageChanged = bookPriceThirdPage.replace(".", "").replace("$", "");
	
     	assertEquals(bookPriceSecondPage, bookPriceThirdPageChanged);
		
	}
         
	//5. Click on Add to Cart.
	//6. Before Click on Proceed to Checkout asset price from Step3.
	 //7. Click on proceed to checkout
	@Then("The user clicks on Add to Cart and proceed to checkout")
	public void theUserClicksOnAddToCartAndProceedToCheckout() {
		ThirdPage tp = new ThirdPage();
	tp.addToCart.click();
	String bookPriceBeforeCheckOut = tp.bookPriceBeforeCheckOut.getText();
	String bookPriceBeforeCheckOutChanged = bookPriceBeforeCheckOut.replace(".", "").replace("$", "");
	
	assertEquals(bookPriceSecondPage, bookPriceBeforeCheckOutChanged);
	tp.proceedToCheckOut.click();
	}
	
	//8. On the checkout page assert price from Step3.
	@Then("Verify checkout price with price on second page")
	public void verifyCheckoutPriceWithPriceOnSecondPage() {
		
		ForthPageCheckout fp = new ForthPageCheckout();
		String bookPriceCheckOut = fp.bookPriceCheckOut.getText();
		System.out.println(bookPriceCheckOut);
		
		
		assertEquals(bookPriceSecondPage, bookPriceCheckOut);
	}
}
