package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Page.LoginPage;
import util.BrowserFactory;

public class LoginTest {
WebDriver driver;


@Test
@Parameters({"username","password"})
public void verifyingtheloginpage(String userName, String password ) {
	driver = BrowserFactory.init();
	
	LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	loginpage.insertusernamefield(userName);
	loginpage.insertpasswordfield(password);
	loginpage.clicksigninbutton();
}
}
