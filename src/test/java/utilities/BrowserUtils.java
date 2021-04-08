package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowserUtils {
		
	public static void waitForPageToLoad(int seconds) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		try {
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
			wait.until(expectation);
		} catch (Throwable error) {
			System.out.println("Timed out waiting for page load");
		}
	}

}