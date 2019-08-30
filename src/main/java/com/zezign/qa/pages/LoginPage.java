package com.zezign.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zezign.qa.base.Testbase;

public class LoginPage extends Testbase {

	@FindBy(xpath = "//i[contains(@class,'fa fa-sign-in')]")
	WebElement loginbutton;
	@FindBy(xpath = "//input[@name='email']")
	WebElement EmailAddress;
	@FindBy(xpath = "//input[@name='password']")
	WebElement Password;
	@FindBy(xpath = "//button[@title='Login']")
	WebElement login;

	@FindBy(xpath = "//img[contains(@alt,'Zezign Logo')]")
	WebElement logo;
	@FindBy(xpath = "//img[contains(@alt,'whatsapp_me')]")
	WebElement whatsapplogo;
	// pagefactory

	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	// Actions
	public String validateloginpagetitle() {
		
		return driver.getTitle();

	}

	public boolean validatelogo() {

		return logo.isDisplayed();
	}

	public boolean whatsapplogo() {

		return whatsapplogo.isDisplayed();

	}

	public Homepage login(String mailid, String pwd) {
		loginbutton.click();
		EmailAddress.sendKeys(mailid);
		Password.sendKeys(pwd);
		login.click();
		return new Homepage();

	}
}
