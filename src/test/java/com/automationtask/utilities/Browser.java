package com.automationtask.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Browser {
	public static WebDriver driver ;

	public static WebDriver openBrowser(String myBrowser) throws Exception {
		if (driver == null) {
			if (myBrowser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.firefox.marionette", ".//geckodriver");
				driver = new FirefoxDriver();
			} else if (myBrowser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (myBrowser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", ".//IEDriverServer");
				driver = new InternetExplorerDriver();
			} else {
				throw new Exception("Browser is not correct");
			}

		}
		return driver;
	}
	
	@BeforeTest
	public void setup() throws Exception {

		openBrowser("Chrome");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		if (driver != null) {
			System.out.println("Test Done!!!");
			driver.quit();
		}
	}
}
