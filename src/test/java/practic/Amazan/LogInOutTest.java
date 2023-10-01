package practic.Amazan;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class LogInOutTest {
	public static void main(String[] args) {
		// Set the WebDriver path and start the browser
		EdgeOptions option =new EdgeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver=new EdgeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		// Step 1: Navigate to Amazon
		driver.get("https://www.amazon.in/");

		driver.findElement(By.xpath("//span[contains(text(),'Hello, sign in')]")).click();

		//					   Actions action=new Actions(driver);
		//			 action.moveToElement(account).perform();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("7026246871"+Keys.ENTER);

		driver.findElement(By.id("ap_password")).sendKeys("123789456"+Keys.ENTER);
		// Step 2: Search and add items to cart
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Product Name", Keys.ENTER);		
		driver.findElement(By.xpath("//span[contains(text(),'Personalised 3D flip ')]")).click();

		Set<String> windows=driver.getWindowHandles();

		for (String id:windows)    
		{
			driver.switchTo().window(id);
		}

		driver.findElement(By.xpath("//input[@id=\"add-to-cart-button\"]")).click();

		// Step 3: Verify cart contents
		WebElement cartIcon = driver.findElement(By.id("nav-cart-count"));
		int cartItemCount = Integer.parseInt(cartIcon.getText());

		if (cartItemCount > 0) {
			System.out.println("Product added to cart successfully!");
		} else {
			System.out.println("Failed to add the product to cart!");
		}
		WebElement total= driver.findElement(By.xpath("//span[contains(text(),'Subtotal')]"));

		System.out.println(total);
		// Step 4: Log Out
		WebElement account= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		Actions action=new Actions(driver);
		action.moveToElement(account).perform();
		WebElement signOutButton = driver.findElement(By.xpath("//span[text()='Sign Out']"));
		signOutButton.click();

		// Step 5: Log In
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("7026246871"+Keys.ENTER);
		driver.findElement(By.id("ap_password")).sendKeys("123789456"+Keys.ENTER);
		// Step 6: Navigate to cart
		WebElement cartIccon = driver.findElement(By.id("nav-cart-count"));
		cartIccon.click();


		System.out.println("after login"+total);
		// Step 7: Verify cart contents again
		//	        int cartIttemCount = Integer.parseInt(cartIcon.getText());
		//
		//		      if (cartIttemCount > 0) {
		//		          System.out.println("Product in cart are present");
		//		      } else {
		//		          System.out.println("product in the   cart are empty! ");
		//		      }

		// Close the browser
		driver.quit();
	}
}
