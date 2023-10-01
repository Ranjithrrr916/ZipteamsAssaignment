package practic.Amazan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class ProductTotalAmountTc_3 {

	public static void main(String[] args) {
		EdgeOptions option =new EdgeOptions();
	      option.addArguments("--remote-allow-origins=*");
			WebDriver driver=new EdgeDriver(option);
		  // Navigate to Amazon
    driver.get("https://www.amazon.in/");

    // Search and click on a product to add it to the cart (replace 'product_name' with the desired product)
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("product_name");
    // Find the search button and click it
    WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
    searchButton.click();

    // Find the first product in the search results and click on it to go to the product page
    WebElement firstProduct = driver.findElement(By.xpath("(//span[contains(text(),'abels & Receipt Printer (50x25 Label Combo)')])[1]"));
    firstProduct.click();
    // Go to the cart page
    driver.get("https://www.amazon.com/gp/cart/view.html");

    // Get the total number of items in the cart
    int actualItemCount = Integer.parseInt(driver.findElement(By.id("nav-cart-count")).getText());

    // You can retrieve the expected item count from your test data or by adding more products manually.
    int expectedItemCount = 1;

    // Verify the total amount of items in the cart is displayed correctly
    if (actualItemCount == expectedItemCount) {
        System.out.println("Cart item count displayed correctly: " + actualItemCount);
    } else {
        System.out.println("Cart item count is incorrect. Expected: " + expectedItemCount + ", Actual: " + actualItemCount);
    }

    // Close the browser
    driver.quit();
	}

}
