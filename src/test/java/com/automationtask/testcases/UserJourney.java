package com.automationtask.testcases;

import org.testng.annotations.Test;

import com.automationtask.pages.LoginPage;
import com.automationtask.pages.PurchasePage;
import com.automationtask.utilities.Browser;

public class UserJourney extends Browser{
	
	@Test
	public void purchase() throws InterruptedException {

		//Login to the account
		LoginPage.userLogin("yzrwhuqtlz@mails.omvvim.edu.in", "123456");

		//purchase any products
		PurchasePage.purchaseDress();


		//Login to the account
		LoginPage.userLogin("dawlnaxvak@email.ucms.edu.pk", "123456");

		//purchase any products
		PurchasePage.purchaseDress();
	}

	
	
}
