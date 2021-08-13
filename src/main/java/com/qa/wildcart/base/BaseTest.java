package com.qa.wildcart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.wildcart.pages.HomePage;
import com.qa.wildcart.pages.LoginPage;
import com.qa.wildcart.pages.MyAccount;
import com.qa.wildcart.pages.RegistrationPage;

public class BaseTest {
	
	//TestNg -- unit testing framework use with java and junit also
		//preconditions .... testcase(step) .... assertion.....close test
		//@Beforetest......@Test.....Assertions.....close the browser
		//launch browser..,url,...title....verify....close the browser
	//http://192.168.99.100:4444/wd/hub
	     public WebDriver driver;
	     public BasePage basepage;
	     public LoginPage loginpage;
	     public HomePage homepage;
	     public MyAccount myaccount;
	     public Properties prop;
	     public RegistrationPage registerpage;
		
	     
	     
	   // @Parameters("browser")
		@BeforeTest
	//	public void setUp(String browserName) {
		public void setup() {  //sanity
			basepage=new BasePage();
			prop=basepage.init_prop();
		//	prop.setProperty("browser",browserName);
			prop.getProperty("browser");   //sanity

			//String brw=prop.getProperty("browser");
//			if (browserName != null) {
//				brw = browserName;
//			}
			driver=basepage.initl_driver(prop);
			loginpage=new LoginPage(driver);
			driver.get(prop.getProperty("url"));

			
		}
	
		@AfterTest
		public void closeBrowser() {
			driver.quit();
		}
	
	

}
