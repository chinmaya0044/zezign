package com.zezign.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zezign.qa.base.Testbase;
import com.zezign.qa.pages.Homepage;
import com.zezign.qa.pages.LoginPage;

public class loginPageTest extends Testbase {
	LoginPage loginpage;
	Homepage homepage ;

	public loginPageTest() {

		//super();
		System.out.println("loginpagetest");	
}

	@BeforeMethod
	public void setup() {
		System.out.println("loginpagetest1");	
		initialization();
		loginpage = new LoginPage();
	}

	@Test(priority = 2)
	public void zezignlogoTest() {

		boolean zezignlogo = loginpage.validatelogo();
		Assert.assertTrue(zezignlogo);

	}

	@Test(priority = 3)
	public void zezignwhatsapplogoTest() {

		boolean logo = loginpage.whatsapplogo();
		Assert.assertTrue(logo);

	}

	@Test(priority = 1)
	public void ZezignTitle() {

		String title = loginpage.validateloginpagetitle();
		Assert.assertEquals(title, "Zezign");
	}

	@Test(priority = 4)
	public void LoginTest() {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void teardown() {

		driver.quit();
	}

}
