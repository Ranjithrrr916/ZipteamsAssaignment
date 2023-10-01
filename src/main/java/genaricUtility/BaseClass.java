package genaricUtility;


import java.io.IOException;

import java.sql.Driver;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	
	public WebDriver driver=null;
	
	@BeforeSuite
	public void bsConfig() {
		System.out.println("----- database connection successful -----");
	}
	
	//@BeforeTest
		@BeforeClass
		public void bcConfig() throws IOException {

		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		
		
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			
		}
		else if (BROWSER.equalsIgnoreCase("Edge")) 
		{
			EdgeOptions option =new EdgeOptions();
			option.addArguments("--remote-allow-origins=*"); 
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver(option);
			
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
		     driver=new FirefoxDriver();
			
		}
				
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
	}

		//@BeforeMethod
		public void bmConfig() 
		{
					
			System.out.println("--- Login to APP successful ---");
		}

		@AfterMethod
		public void amConfig() 
		{
					
			System.out.println("--- logout of APP successful ---");
		}
		
		//@Test
		@AfterClass
		public void acConfig() 
		{
	         driver.quit();
	         System.out.println("--- Browser closed ---");
		}

		@AfterSuite
		public void asConfig() {
			System.out.println("----- database closed successfully -----");
		}

	
	
}
