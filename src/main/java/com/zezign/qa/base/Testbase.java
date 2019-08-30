package com.zezign.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.zezign.qa.util.TestUtil;
import com.zezign.qa.util.webdriverListener;

public class Testbase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;
	
	public void TestBase() {
//		try {
//			prop = new Properties();
//			FileInputStream ip = new FileInputStream("C:/Users/VirtualDusk/eclipse-workspace/com.zezign.test/src/main/java/com/zezign/qa/config/config.properties");
//			prop.load(ip);
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println("loginpagetest2");	
	}

	public static void initialization() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:/Users/VirtualDusk/eclipse-workspace/com.zezign.test/src/main/java/com/zezign/qa/config/config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String browserName = prop.getProperty("browser");
		System.out.print("Hello : "+browserName);
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/VirtualDusk/Desktop/chromedriver.exe/");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "E:/driver code/geckodriver.exe");
			driver = new FirefoxDriver();
		}   
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new webdriverListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		
		System.out.println("loginpagetest3");	
	}

}
