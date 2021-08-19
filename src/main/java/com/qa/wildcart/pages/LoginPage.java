package com.qa.wildcart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.wildcart.base.BasePage;
import com.qa.wildcart.utilites.Constants;
import com.qa.wildcart.utilites.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	private ElementUtil elementutil;
	
	
	// By Locators
	By loginBtn=By.id("dLabellogin");
	By userName=By.id("username");
	By passWord=By.id("password");
	By loginButton=By.id("jqLogin");
	By signUp=By.id("jqSignup1");
	
	//constructor of the page class
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementutil= new ElementUtil(this.driver);
	}
	
	//page action
	@Step("getting the login page title")
	public String getLoginPageTitle() {
		//return driver.getTitle();
		return elementutil.doGetPageTitleWithContains(10,Constants.LOGIN_PAGE_TITLE);
			
	}
	@Step("checking the link is exist or not")
	public boolean isSignUpButtonExists() {
		//driver.findElement(loginBtn).click();
		//return driver.findElement(signUp).isDisplayed();
		
		elementutil.waitForElementToBeClickable(loginBtn, 10).click();
		return elementutil.isElementDisplayed(signUp, 10);
		
			
	}
	@Step("login with username :{0} and password : {1}")
	public HomePage doLogin(String UserName,String PassWord) {
		

//		driver.findElement(userName).sendKeys(UserName);
//		driver.findElement(passWord).sendKeys(PassWord);
//		driver.findElement(loginButton).click();
		
		elementutil.waitForElementToBeVisible(userName, 10).sendKeys(UserName);
		elementutil.getElement(passWord).sendKeys(PassWord);
		elementutil.getElement(loginButton).click();
		
		
		return new HomePage(driver);
		
		
		
	}
	
	public RegistrationPage dosignup() {
		driver.findElement(loginBtn).click();
		driver.findElement(signUp).click();
		return new RegistrationPage(driver);

		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
