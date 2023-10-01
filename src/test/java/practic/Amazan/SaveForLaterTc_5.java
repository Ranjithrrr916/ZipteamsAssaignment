package practic.Amazan;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

public class SaveForLaterTc_5 {

	public static void main(String[] args) {
		EdgeOptions option =new EdgeOptions();
	      option.addArguments("--remote-allow-origins=*");
			WebDriver driver=new EdgeDriver(option);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.amazon.in/");
			String parentID=driver.getWindowHandle();
			 WebElement account=driver.findElement(By.id("nav-link-accountList"));
			    account.click();
			driver.findElement(By.id("ap_email")).sendKeys("7026246871"+Keys.ENTER);
			//driver.findElement(By.id("continue")).click();
			driver.findElement(By.id("ap_password")).sendKeys("123789456"+Keys.ENTER);
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Product Name", Keys.ENTER);		
			WebElement product=driver.findElement(By.xpath("//span[contains(text(),' Couple Dual Colour (Glitter Black and Glitter Red)')]"));
			product.click();
			
Set<String> windows=driver.getWindowHandles();
			
			for (String id:windows)
			{
				driver.switchTo().window(id);
			}
			
	    driver.findElement(By.xpath("//input[@id=\"add-to-cart-button\"]")).click();
	   driver.findElement(By.xpath("//a[contains(text(),'Go to Cart')]")).click();
	    
	   driver.findElement(By.xpath("//input[contains(@aria-label,'Save for later ')]")).click();
	   driver.switchTo().window(parentID);
	   
			   Actions action=new Actions(driver);
		 action.moveToElement(account).perform();
	 
	   
	    driver.findElement(By.xpath("//span[text()='Your Subscribe & Save Items']")).click();

	    		if (product.isDisplayed())
	    		{
	    			System.out.println("Displyed");
	    		}
	    			
	}
}
