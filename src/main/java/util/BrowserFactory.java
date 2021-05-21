package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
static WebDriver driver;
static String browser;
static String url;

public static void readConfig() {
	
	Properties prop = new Properties();
	
	try {
		InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
		prop.load(input);
		browser = prop.getProperty("browser");
		url = prop.getProperty("url");
	}
	catch(IOException e) {
		e.printStackTrace();
	}
}

public static WebDriver init() {
	readConfig();
	if(browser.equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	}
	else if (browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	driver.get(url);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;

}
public static void teardown() {
	 driver.close();
	 driver.quit();
}
}