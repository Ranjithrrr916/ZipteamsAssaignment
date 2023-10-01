package practic.Amazan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgePractice {

	public static void main(String[] args) {

		EdgeOptions option =new EdgeOptions();
		option.addArguments("--remote-allow-origins=*"); 
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver(option);
		
	        driver.get("https://www.amazon.in/");
	}

}
