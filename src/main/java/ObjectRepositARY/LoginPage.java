
package ObjectRepositARY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genaricUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {

    @FindBy(id = "ap_email")
    private WebElement emailField;

    @FindBy(id = "ap_password")
    private WebElement passwordField;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(xpath = "//a[@data-nav-ref='nav_ya_signin']")
    private WebElement signInBtn;
    //
    
    @FindBy(id = "signInSubmit")
    private WebElement signAct;
    
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    
    public WebElement getSignAct() {
		return signAct;
	}


	public WebElement getEmailField() {
		return emailField;
	}


	public WebElement getPasswordField() {
		return passwordField;
	}


	public WebElement getContinueBtn() {
		return continueBtn;
	}


	public WebElement getSignInBtn() {
		return signInBtn;
	}

//
	public void enterEmail(String email) {
        emailField.sendKeys(email);
        continueBtn.click();
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
        

    }

    public void clickSignIn() {
        signInBtn.click();
        
      //  mouseHoverAction(driver,  signInBtn);
    }
    
    public void logToApp()
	{
    	signAct.click();
		
		 
	}
}

