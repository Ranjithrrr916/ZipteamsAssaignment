package ObjectRepositARY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genaricUtility.WebDriverUtility;

public class SearchProductResultPage extends WebDriverUtility
{
	@FindBy(xpath = "//span[contains(text(),' Couple Dual Colour (Glitter Black and Glitter Red)')]")
	private WebElement ProductLink;

	public SearchProductResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductLink() {
		return ProductLink;
	}

//
	public void clickOnProductLink()
	{
		ProductLink.click();
	}
}
