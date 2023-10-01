package practic.Amazan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
public class FacegenieLogin {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver.
    	EdgeOptions option =new EdgeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver=new EdgeDriver(option);
        // Navigate to the Facegenie login page.
        driver.get("https://www.facegenie.com/login");
        // Enter the username.
        driver.findElement(By.id("username")).sendKeys("your_username");
        // Enter the password.
        driver.findElement(By.id("password")).sendKeys("your_password");
        // Click the login button.
        driver.findElement(By.id("login-button")).click();
        // Wait for the login to complete.
        Thread.sleep(1000);
        // Verify that the login was successful.
        if (driver.findElement(By.id("user-profile")).isDisplayed()) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
        // Close the browser.
        driver.quit();
    }
}