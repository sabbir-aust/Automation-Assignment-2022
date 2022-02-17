package com.automationtask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationtask.testcases.UserJourney;

public class LoginPage extends UserJourney{

	static WebDriverWait wait = new WebDriverWait(driver, 10);
	
	public static void userLogin(String email, String pass) {
		
		driver.manage().deleteAllCookies();
		driver.get("http://automationpractice.com/index.php");
		
		WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Log in to your customer account']")));
		signIn.click();
		
		WebElement emailId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		emailId.sendKeys(email);
		
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='passwd']")));
		password.sendKeys(pass);
		
		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='SubmitLogin']")));
		login.click();
		
		
		
	}
	
}
