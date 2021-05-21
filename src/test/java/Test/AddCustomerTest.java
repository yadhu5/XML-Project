package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Page.AddCustomerPage;
import Page.DashboardPage;
import Page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {

	WebDriver driver;

	//@Test
	@Parameters({ "username", "password", "customername", "compnayname", "email", "phone", "address", "city", "state",
			"zip", "country" })
	public void validatingcustomer(String userName, String password, String customername, String compnayname,
			String email, String phone, String address, String city, String state, String zip, String country) {

		driver = BrowserFactory.init();

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertusernamefield(userName);
		loginpage.insertpasswordfield(password);
		loginpage.clicksigninbutton();

		DashboardPage dashboardpage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.verifyingthedashboardpage();
		dashboardpage.ClickCustomerButton();
		dashboardpage.ClickAddCustomerButton();

		AddCustomerPage addcustomerpage = PageFactory.initElements(driver, AddCustomerPage.class);
		addcustomerpage.insertcustomerfullname(customername);
		addcustomerpage.insertcomapnyname(compnayname);
		addcustomerpage.insertemail(email);
		addcustomerpage.insertphonenumber(phone);
		addcustomerpage.insertaddress(address);
		addcustomerpage.insertcity(city);
		addcustomerpage.insertcountry(country);
		addcustomerpage.insertstate(state);
		addcustomerpage.insertzipcode(zip);
		addcustomerpage.clicksubmitbutton();

		dashboardpage.verifyingthecustomersummerypage();
		addcustomerpage.verifyEnteredCustomerNameAnddelete();

	}

	@Test
	@Parameters({ "username", "password", "customername", "compnayname", "email", "phone", "address", "city", "state",
			"zip", "country" })
	public void userShouldAbleToUseSearchBarOnListCustomer(String userName, String password, String customername,
			String compnayname, String email, String phone, String address, String city, String state, String zip,
			String country) {
		driver = BrowserFactory.init();

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertusernamefield(userName);
		loginpage.insertpasswordfield(password);
		loginpage.clicksigninbutton();

		DashboardPage dashboardpage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.verifyingthedashboardpage();
		dashboardpage.ClickCustomerButton();
		dashboardpage.ClickOnListCustomerButton();

		AddCustomerPage addcustomerpage = PageFactory.initElements(driver, AddCustomerPage.class);
		addcustomerpage.clickAddCustomerOnListCustomer();
		addcustomerpage.insertcustomerfullname(customername);
		addcustomerpage.insertcomapnyname(compnayname);
		addcustomerpage.insertemail(email);
		addcustomerpage.insertphonenumber(phone);
		addcustomerpage.insertaddress(address);
		addcustomerpage.insertcity(city);
		addcustomerpage.insertcountry(country);
		addcustomerpage.insertstate(state);
		addcustomerpage.insertzipcode(zip);
		addcustomerpage.clicksubmitbutton();

		dashboardpage.verifyingthecustomersummerypage();

		dashboardpage.ClickOnListCustomerButton();
		addcustomerpage.enteredNameOnSearchBarOnListCustomer();
		addcustomerpage.TestListCustomerSummaryButton();

		dashboardpage.verifyingthecustomersummerypage();
		
		BrowserFactory.teardown();
	}
}
