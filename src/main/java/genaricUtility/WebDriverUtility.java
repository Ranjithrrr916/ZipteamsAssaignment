package genaricUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverUtility
{
	
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize(); //action
	}

	
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}

	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	

	public void handleDropdown(WebElement Element, int index)
	{
		Select sel = new Select(Element);
		sel.selectByIndex(index);
	}
	
	
	public void handleDropdown(WebElement element, String Value)
	{
		Select sel = new Select(element);
		sel.selectByValue(Value);
	}
	

	public void handleDropdown(String Text, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(Text);
	}
	

	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
	public void rightClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	

	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	

	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement dstElement)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, dstElement).perform();
	}


	public void handleDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	
	public String takeScreenShot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots\\"+screenshotName+".png");
		FileUtils.copyFile(src, dst); // commons io dependency
		
		return dst.getAbsolutePath(); // used in extent reports
		
	}
	
	
	public void switchToWindow(WebDriver driver, String partialWinTitle) 
	{
		//Step 1: capture all the window IDs
		Set<String> winIds = driver.getWindowHandles();
		
		//Step 1: use a for each loop and navigate to each window
		for(String win:winIds)
		{
			//Step 3: capture the title of each window
			String currentTitle = driver.switchTo().window(win).getTitle();
			
			//Step 4: compare the current Title with partial window title
			if(currentTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	
	
	
	
}
