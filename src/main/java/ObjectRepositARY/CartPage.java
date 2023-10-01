
package ObjectRepositARY;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genaricUtility.WebDriverUtility;

public class CartPage  extends WebDriverUtility
{
  @FindBy(xpath = "//input[@aria-labelledby=\"sc-buy-box-ptc-button-announce\"]")
  private WebElement ProceedtoBuyBtn;
  
   @FindBy(xpath ="//input[contains(@aria-label,\"Delete kidsROAR Electric Bike\")]" )
   private WebElement DeleteBtn;
   
   @FindBy(xpath = "//input[@id='nav-search-submit-button']")
   private WebElement SaveforLaterBtn;
   
   @FindBy(xpath = "//span[text()='Personalised 3D flip Name Couple Dual Colour (Glitter Black and Gl…']")
   private WebElement firstProductName;
   
   @FindBy(xpath="//span[contains(@class,'a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text')]")
   private WebElement firstProductPrice;
   
   @FindBy(css = "span#sc-subtotal-amount-activecart")
   private WebElement totalAmountElement;
   
   @FindBy(xpath="//span[contains(text(),'Personalised 3D flip Name Cou')]/parent::span")
   private WebElement CartProduct;
   
   public CartPage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }


public WebElement getProceedtoBuyBtn() {
	return ProceedtoBuyBtn;
}


public WebElement getDeleteBtn() {
	return DeleteBtn;
}

public WebElement getFirstProductName() {
    return firstProductName;
}

public WebElement getFirstProductPrice() {
    return firstProductPrice;
}




public WebElement getSaveforLaterBtn() {
	return SaveforLaterBtn;
}


public WebElement getTotalAmountElement() {
	return totalAmountElement;
}


public String getTotalAmount() {
    return totalAmountElement.getText();
}


  

   public WebElement getCartProduct() {
	return CartProduct;
}
   ///

public void clickOnProceedToBuyBtn()
   {
	   ProceedtoBuyBtn.click();
   }
   
   public void clickOnDeleteBtn()
   {DeleteBtn.click();
	   
   }
   public void clickOnSaveForLaterBtn()
   {
	   SaveforLaterBtn.click();
	   
   }
   public void clickONFirstProductName()
   {
	   firstProductName.click();
   }
   public String clickOnFirstProductName() {
      
	return firstProductName.getText();
   }
   public String clickOnFirstProductPrice() {
       firstProductPrice.click();
	return firstProductPrice.getText();
   }
   
   public void ClickOnCartProduct(WebDriver driver)
   {
	   switchToWindow(driver, "product");
	   CartProduct.click();
   }
}
