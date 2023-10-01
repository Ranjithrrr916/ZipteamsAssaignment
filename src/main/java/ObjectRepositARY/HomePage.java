package ObjectRepositARY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genaricUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	@FindBy(id = "twotabsearchtextbox")
	private WebElement SearchTextEdt;

	@FindBy(id="nav-search-submit-button")
	private WebElement SubmitBtn;

	@FindBy(id = "nav-cart")
	private WebElement CartImg;
//
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	public WebElement getSearchTextEdt() {
		return SearchTextEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	public WebElement getCartImg() {
		return CartImg;
	}

	//

	public void searchTextField(String ITEM)
	{
		SearchTextEdt.sendKeys(ITEM);
		SubmitBtn.click();		
	}
	public void clickOnCartImg()
	{
		CartImg.click();
	}

}
