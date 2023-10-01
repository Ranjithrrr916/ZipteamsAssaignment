package practic.Amazan;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class ProductDisplayPageTc_4 {

	public static void main(String[] args) {
		EdgeOptions option =new EdgeOptions();
	      option.addArguments("--remote-allow-origins=*");
	      
	     // WebDriverManager.edgedriver().setup();
			WebDriver driver=new EdgeDriver(option);
		  // Navigate to Amazon
    driver.get("https://www.amazon.in/");
		
    
    // Find the search box and enter the product you want to search for
    WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
    searchBox.sendKeys("Product Name");

    // Find the search button and click it
    WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
    searchButton.click();

    // Find the first product in the search results and click on it to go to the product page
    WebElement firstProduct = driver.findElement(By.xpath("(//span[contains(text(),'abels & Receipt Printer (50x25 Label Combo)')])[1]"));
    firstProduct.click();
    
    Set<String> windows=driver.getWindowHandles();
	
	for (String id:windows)
	{
		driver.switchTo().window(id);
	}
    // Find the "Add to Cart" button and click it
    WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
    addToCartButton.click();

		
    // TODO: Perform login or cart operations to add a product to the cart

        // Now, navigate to the cart page
        driver.get("https://www.amazon.com/gp/cart/view.html");

        // Find the product element in the cart
        WebElement productInCart = driver.findElement(By.xpath("(//span[contains(text(),'abels & Receipt Printer (50x25 Label Combo)')])[1]"));

        // Get the URL of the product display page
        String productUrlInCart = productInCart.getAttribute("href");

        // Click on the product in the cart
        productInCart.click();

        // Get the URL of the current page after clicking the product
        String currentUrl = driver.getCurrentUrl();

        // Verify if the URLs match
        if (currentUrl.equals(productUrlInCart)) {
            System.out.println("The product in the cart leads to the same product display page.");
        } 
        else {
            System.out.println("The product in the cart does not lead to the same product display page.");
        }

        // Close the browser
        driver.quit();

	}

}
