package ObjectRepositARY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genaricUtility.WebDriverUtility;

public class ProductPage extends WebDriverUtility {
	
	@FindBy(id = "submit.add-to-cart")
	private WebElement addToCartBtn;
	
	  @FindBy(xpath  = "//span[contains(text(),'Personalised 3D flip Name Cou')]/parent::a")
	    private WebElement productName;

	    @FindBy(xpath="((//span[contains(text(),'499')]/parent::span)[1])")
	    private WebElement productPrice;

	
	public ProductPage(WebDriver driver)

	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}
	public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }
	
	
	
	//
	
	public void clickOnAddToCart(WebDriver driver)
	{
		switchToWindow(driver, "Personalised");
		addToCartBtn.click();
	}
	public void clickOnProductName()
	{
		
	}
	
	
}



