package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver= driver;
		
	}
	@FindBy(how=How.XPATH,using = "//input[@id='username']") WebElement USER_NAME_FIELD;
	@FindBy(how=How.XPATH,using = "//input[@id='password']") WebElement PASSWORD_FIELD;
	@FindBy(how=How.XPATH,using = "//button[@type='submit']") WebElement USER_SIGNIN_BUTTON;
	
	public void insertusernamefield(String username) {
		USER_NAME_FIELD.sendKeys(username);
		
	}
	public void insertpasswordfield(String password) {	
		PASSWORD_FIELD.sendKeys(password);
		
	}
	public void clicksigninbutton() {
		USER_SIGNIN_BUTTON.click();
	}
}
