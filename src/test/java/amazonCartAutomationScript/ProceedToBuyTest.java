package amazonCartAutomationScript;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import genaricUtility.BaseClass;
import genaricUtility.ExcelFileUtility;
import genaricUtility.PropertyFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import ObjectRepositARY.CartPage;
import ObjectRepositARY.HomePage;
import ObjectRepositARY.ProductPage;
import ObjectRepositARY.SearchProductResultPage;
import genaricUtility.WebDriverUtility;


public class ProceedToBuyTest  extends BaseClass
{

	@Test
	public  void proceedToBuyTest()throws IOException

	{

		String ITEM=eUtil.readDataFromExcel("Qdex", 1, 2);


		HomePage hp=new HomePage(driver);
		hp.searchTextField(ITEM);

		SearchProductResultPage srp=new SearchProductResultPage(driver);
		srp.clickOnProductLink();

		ProductPage pp=new ProductPage(driver);
		pp.clickOnAddToCart(driver);

		CartPage cp = new CartPage(driver);


		cp.clickOnProceedToBuyBtn();
		System.out.println("The items are ready to buy please chosse address");


	}
}

