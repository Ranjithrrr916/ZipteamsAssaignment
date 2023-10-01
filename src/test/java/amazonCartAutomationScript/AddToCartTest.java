package amazonCartAutomationScript;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import ObjectRepositARY.HomePage;
import ObjectRepositARY.ProductPage;
import ObjectRepositARY.SearchProductResultPage;
import genaricUtility.BaseClass;
import genaricUtility.ExcelFileUtility;
import genaricUtility.PropertyFileUtility;
import genaricUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCartTest extends BaseClass
{
@Test
	public  void addtocartTest() throws IOException 
 {
		
			String ITEM=eUtil.readDataFromExcel("Qdex", 1, 2);
			
     
      // Find the search box and enter the product you want to search for
     HomePage hp=new HomePage(driver);
   hp.searchTextField(ITEM);
   
   SearchProductResultPage srp=new SearchProductResultPage(driver);
		   srp.clickOnProductLink();
		  
		   ProductPage pp=new ProductPage(driver);
		   pp.clickOnAddToCart(driver);
		   
		   System.out.println("The product added to cart");
		  
		   	   	   
	}
	}
   

