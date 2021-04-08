package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {   
	
	private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>(); 
	
	private Driver() {}
	
	
	
	public static synchronized WebDriver getDriver(String browser) {
		
		if(drivers.get() == null) {
			
			if(browser == null) {
				browser = ConfigReader.getProperty("browser").toLowerCase();
			}
			
			
			
			switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				drivers.set(new ChromeDriver());
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				drivers.set(new EdgeDriver());
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				drivers.set(new FirefoxDriver());
				break;
			case "opera":
				WebDriverManager.operadriver().setup();
				drivers.set(new OperaDriver());
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				drivers.set(new InternetExplorerDriver());
				break;
			case "headlesschrome":
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--disable-gpu"); // option that must be added only for Windows systems
				drivers.set(new ChromeDriver(options));
				break;	
			case "headlessfirefox":
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions foptions = new FirefoxOptions();
	            foptions.addArguments("--headless");
	            drivers.set(new FirefoxDriver(foptions));
				break;	
			case "htmlunit":
				drivers.set(new HtmlUnitDriver(true)); //true --> enables JavaScript
				break;		
				
			default:
				System.out.println("Wrong driver");
				break;
			}
			
			
			
			
		}
		
		
		
		return drivers.get();
		
	}
	
	
	
	public static WebDriver getDriver() {
		return getDriver(null);
	}
	
	
	
	public static synchronized void quit() {  
		
		
		if(drivers.get() != null) {
			drivers.get().quit();
			drivers.remove();
		}
		
		
	}
	

}
