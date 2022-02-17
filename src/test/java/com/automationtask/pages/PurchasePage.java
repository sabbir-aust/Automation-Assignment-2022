package com.automationtask.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automationtask.testcases.UserJourney;



public class PurchasePage extends UserJourney{
	
	static WebDriverWait wait = new WebDriverWait(driver, 10);
	
	public static void purchaseDress() throws InterruptedException {
		
		WebElement dressess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='page']/div/header[@id='header']/div/div/div/div[@id='block_top_menu']/ul/li[2]/a[1]")));
		dressess.click();
		String url = driver.getCurrentUrl();
		Assert.assertEquals("http://automationpractice.com/index.php?id_category=8&controller=category", url);
		
		WebElement casualDress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Casual Dresses']//img")));
		casualDress.click();
		String url2 = driver.getCurrentUrl();
		Assert.assertEquals("http://automationpractice.com/index.php?id_category=9&controller=category", url2);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		
		WebElement selectItem1 = driver.findElement(By.xpath("//h5[@itemprop='name']//a[@title='Printed Dress']"));
		selectItem1.click(); 

		WebElement addToCart = driver.findElement(By.xpath("//span[normalize-space()='Add to cart']"));
		addToCart.click(); 
		Thread.sleep(2000);
		String success = driver.findElement(By.xpath("//div[@id='layer_cart']//div//div[1]//h2[1]")).getText();
		Assert.assertEquals(success, "Product successfully added to your shopping cart");
		
		WebElement continueShopping = driver.findElement(By.xpath("//span[@title='Continue shopping']"));
		continueShopping.click(); 
		
		WebElement tShirt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div/div/header/div/div/div/div/ul/li[3]/a[1]")));
		tShirt.click();
		
		WebElement blue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='layered_id_attribute_group_14']")));
		blue.click();
		Thread.sleep(2000);
		
		WebElement selectItem2 = driver.findElement(By.xpath("//h5[@itemprop='name']//a[@title='Faded Short Sleeve T-shirts']"));
		selectItem2.click(); 
		
		WebElement addToCart2 = driver.findElement(By.xpath("//p[@id='add_to_cart']//button[@type='submit']"));
		addToCart2.click(); 
		Thread.sleep(2000);
		String success2 = driver.findElement(By.xpath("//div[@id='layer_cart']//div//div[1]//h2[1]")).getText();
		Assert.assertEquals(success2, "Product successfully added to your shopping cart");
		
		WebElement proceed = driver.findElement(By.xpath("//a[@title='Proceed to checkout']//span"));
		proceed.click(); 
		
		js.executeScript("window.scrollBy(0,1200)");
		WebElement proceedToCheckout = driver.findElement(By.xpath("//div[@id='center_column']//p//span"));
		proceedToCheckout.click(); 
		
		js.executeScript("window.scrollBy(0,1200)");
		WebElement proceedToCheckout2 = driver.findElement(By.xpath("//form[@action='http://automationpractice.com/index.php?controller=order']//button[@type='submit']//span"));
		proceedToCheckout2.click();
		
		WebElement termsCondition = driver.findElement(By.xpath("//input[@id='cgv']"));
		termsCondition.click();
		
		WebElement proceedToCheckout3 = driver.findElement(By.xpath("//form[@id='form']//button[@type='submit']//span"));
		proceedToCheckout3.click();
		
		js.executeScript("window.scrollBy(0,800)");
		WebElement paymentByCheck = driver.findElement(By.xpath("//a[@title='Pay by check.']"));
		paymentByCheck.click();
		
		WebElement confirmOrder = driver.findElement(By.xpath("//p[@id='cart_navigation']//span"));
		confirmOrder.click();
		
		String successOrder = driver.findElement(By.xpath("//div[@id='columns']//p[1]")).getText();
		Assert.assertEquals(successOrder, "Your order on My Store is complete.");
		
		WebElement signout = driver.findElement(By.xpath("//a[@title='Log me out']"));
		signout.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
