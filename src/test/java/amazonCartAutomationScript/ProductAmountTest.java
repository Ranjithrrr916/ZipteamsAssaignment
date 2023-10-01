package amazonCartAutomationScript;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ObjectRepositARY.CartPage;
import ObjectRepositARY.HomePage;
import ObjectRepositARY.ProductPage;
import ObjectRepositARY.SearchProductResultPage;
import genaricUtility.BaseClass;
import genaricUtility.ExcelFileUtility;
import genaricUtility.PropertyFileUtility;
import genaricUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductAmountTest  extends BaseClass
{

	@Test
	public void productAmountTest() throws IOException 
	{
		
    	String ITEM=eUtil.readDataFromExcel("Qdex", 1, 2);
        
        HomePage hp=new HomePage(driver);
        hp.searchTextField(ITEM);
        
        SearchProductResultPage srp=new SearchProductResultPage(driver);
     		   srp.clickOnProductLink();
     		  
     		   ProductPage pp=new ProductPage(driver);
     		   pp.clickOnAddToCart(driver);
     		
     			hp.clickOnCartImg();
     		   
     		  CartPage cp = new CartPage(driver);
     		  
     	        String totalAmount = cp.getTotalAmount();

     	        System.out.println("Total Amount: " + totalAmount);

     	        
     	   if(     cp.getTotalAmount().equals(totalAmount))
     	  {
	    	 System.out.println("the total amount of product is matched");
		     }
		     else 
	     {
		    	 System.out.println("total amount is missmatch");
		     }
     	      
        }
	}


