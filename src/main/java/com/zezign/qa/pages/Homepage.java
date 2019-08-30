package com.zezign.qa.pages;




import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zezign.qa.base.Testbase;
import com.zezign.qa.util.TestUtil;

public class Homepage extends Testbase{
	@FindBy(xpath="//div[contains(@class,'owl-stage-outer')]/div[contains(@class,'owl-stage')]"
			+ "/div[contains(@class,'owl-item active')]/ul[contains(@class,'list-cat')]"
			+ "//a[contains(text(),'T-shirt')]")
	WebElement t_shirt ;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div[1]/a/img")
	WebElement art ;
	
	@FindBy(xpath="//article[@id='posts-list']/div[1]/div/div[1]/div/div/label/div")
	WebElement choose_products ;
	
	@FindBy(xpath="//label[text()='M']")
	WebElement size ;
	
	@FindBy(xpath="//div[contains(@id,'tshirt_color-0')]//ul/descendant::li[contains(@color-code,'#242424')]")
	WebElement color ;
	
	@FindBy(xpath="//div[@class='row']//div//button[@type='button' and contains(@class,'single_add_to_cart_button fpd-btn alt active_btn')]")
	WebElement cart ;

	public Homepage() {

		PageFactory.initElements(driver, this);

	}
	
	public WebElement tshirt() {
		return t_shirt;
	}

	public WebElement art() {
		return art;
	}

	public WebElement chooseproducts() {
		return choose_products ;
	}

	public WebElement size() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", size);

		return size ;
	}

	public WebElement selectcolor() {
		return color;
	}

	public WebElement Addtocart() {
		Actions act = new Actions(driver);
		WebElement menuHoverLink3 = Addtocart() ;
		act.moveToElement(menuHoverLink3);
		act.click();
		act.perform();
		return cart;
	}
	
	public addtocart login() throws InterruptedException {
		 t_shirt.click();
		//driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
	Thread.sleep(2000);
		art.click();
		choose_products.click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		size.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		color.click();

		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cart.click();
		return new addtocart();

	}
	
	
	
	
	
	
	

}
