package practic.Amazan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class ProceedbuttonTc_2 {

	public static void main(String[] args) {
		
		EdgeOptions option =new EdgeOptions();
	      option.addArguments("--remote-allow-origins=*");
			WebDriver driver=new EdgeDriver(option);

		        // Navigate to Amazon.com
			driver.get("https://www.amazon.in/");
			
			//cartimg
			driver.findElement(By.xpath("//span[@class='nav-cart-icon nav-sprite']")).click();

		        // Find the "Proceed" button and click on it
		        WebElement proceedButton = driver.findElement(By.id("proceed-button"));
		        proceedButton.click();

		        // Wait for the page to load
		        try {
		            Thread.sleep(3000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }

		        // Verify if the new page has loaded successfully or not
		        if (driver.getCurrentUrl().equals("https://www.amazon.com/proceed-page")) {
		            System.out.println("Proceed button is working properly.");
		        } else {
		            System.out.println("Proceed button is NOT working properly.");
		        }

		        // Close the browser
		        driver.quit();
		    }
	}

