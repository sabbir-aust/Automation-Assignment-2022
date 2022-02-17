package com.automationtask.pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.automationtask.testcases.SignUp;


public class SignupPage extends SignUp{
		static WebDriverWait wait = new WebDriverWait(driver, 10);
	
	
	public static void userSignUpInfo(String email, String fName, String lName, String pass) throws InterruptedException {
		
		driver.manage().deleteAllCookies();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		//navigate to signup page
		
		WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Log in to your customer account']")));
		signIn.click();
		
		//submit email address
		WebElement emailId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email_create']")));
		emailId.sendKeys(email);
		
		WebElement createAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='SubmitCreate']//span")));
		createAccount.click();
		
		WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));
		title.click();
		
		WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='customer_firstname']")));
		firstName.sendKeys(fName);
		
		WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='customer_lastname']")));
		lastName.sendKeys(lName);
		
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='passwd']")));
		password.sendKeys(pass);
		
		Select dob_Day = new Select(driver.findElement(By.name("days")));
		dob_Day.selectByValue("10");

		Select dob_Month = new Select(driver.findElement(By.name("months")));
		dob_Month.selectByValue("10");

		Select dob_Year = new Select(driver.findElement(By.name("years")));
		dob_Year.selectByValue("1990");
		
		WebElement company = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='company']")));
		company.sendKeys("Apple");

		WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address1']")));
		address.sendKeys("17/35, Uttara");

		WebElement addressLine2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address2']")));
		addressLine2.sendKeys("3rd floor");

		WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='city']")));
		city.sendKeys("Dhaka");

		Select state = new Select(driver.findElement(By.name("id_state")));
		state.selectByValue("15");

		WebElement zip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='postcode']")));
		zip.sendKeys("12235");

		Select country = new Select(driver.findElement(By.name("id_country")));
		country.selectByValue("21");

		WebElement additionalInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='other']")));
		additionalInfo.sendKeys("Test Data");

		WebElement homePhone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='phone']")));
		homePhone.sendKeys("01300000000");

		WebElement mobilePhone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='phone_mobile']")));
		mobilePhone.sendKeys("01400000000");

		WebElement aliasAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='alias']")));
		while (!aliasAddress.getAttribute("value").equals("")) {
			aliasAddress.sendKeys(Keys.BACK_SPACE);
		}
		aliasAddress.sendKeys("Khilkhet");
		
		WebElement register = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Register']")));
		register.click();

		Thread.sleep(3000);

		
	}
}
