package com.zezign.qa.testcases;

import org.openqa.selenium.support.CacheLookup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zezign.qa.base.Testbase;
import com.zezign.qa.pages.Homepage;
import com.zezign.qa.pages.LoginPage;
import com.zezign.qa.pages.addtocart;

public class HomePageTest extends Testbase{
	LoginPage loginpage;
	Homepage homepage ;
	addtocart cart ;
	@BeforeMethod
	
	public void setup() {
		System.out.println("loginpagetest1");	
		initialization();
		loginpage = new LoginPage();
		//cart= new add_to_cart();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

		
	}
	@Test
	public void  addtocart() throws InterruptedException {
		
		homepage.login();
		
	}
	
	
	
	
	@AfterMethod
	public void teardown() {

		driver.quit();
	}
}
