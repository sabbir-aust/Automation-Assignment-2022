package com.automationtask.testcases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automationtask.pages.SignupPage;
import com.automationtask.utilities.Browser;

public class SignUp extends Browser {

	@Test
	public void signup() throws InterruptedException {

		//1st user
	
		SignupPage.userSignUpInfo("yzrwhuqtlz@mails.omvvim.edu.in", "Sabbir", "Ahmed", "123456");

		if(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication")){
			WebElement alert = driver.findElement(By.xpath("//div[@id='center_column']//div//ol"));
			if(alert.isDisplayed()) {
				Assert.assertFalse(false);
			}}
		else {
			Assert.assertTrue(true);
		}

		Thread.sleep(2000);
		
		//2nd user
		
		SignupPage.userSignUpInfo("dawlnaxvak@email.ucms.edu.pk","Rahim", "Karim", "123456");

		if(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication")){
			WebElement alert = driver.findElement(By.xpath("//div[@id='center_column']//div//ol"));
			if(alert.isDisplayed()) {
				Assert.assertFalse(false);
			}}
		else {
			Assert.assertTrue(true);
		}

	}


}
