package com.qa.wildcart.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.wildcart.base.BasePage;
import com.qa.wildcart.pages.LoginPage;
import com.qa.wildcart.pages.RegistrationPage;

public class RegistrationPageTest extends BasePage {

	
	
	WebDriver driver;
    BasePage basepage;
    LoginPage loginpage;
    public Properties prop;

    RegistrationPage registraionpage;

	
	@BeforeTest
	public void setup() {
		basepage=new BasePage();
		prop=basepage.init_prop();

		//driver=basepage.initl_driver("chrome");
		driver=basepage.initl_driver(prop);

		loginpage=new LoginPage(driver);
		registraionpage=loginpage.dosignup();
		
		
	}
	
	
	
	
	@Test
	public void userRegistrationTest() {
		registraionpage.accountRegistration("vcshukl55@gmail.com", "Raj1","ptw123","ptw123","Rajesh11","Patel");
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
	
	
	
}
