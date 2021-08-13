package com.qa.wildcart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.wildcart.base.BasePage;
import com.qa.wildcart.utilites.ElementUtil;

public class RegistrationPage extends BasePage {
	
	private WebDriver driver;
	ElementUtil elementutil;
	HomePage homepage ;
	
	//locators
	
	By emailField = By.xpath("//input[@id='txtEmail']");
	By regUserNameField = By.xpath("//input[@id='txtUserName']");
	By regPasswordField = By.xpath("//input[@id='txtPassword']");
	By regConfPasswordField = By.xpath("//input[@id='txtCnfPassword']");
	By firstNameField = By.xpath("//input[@id='txtFirstName']");
	By lastNameField = By.xpath("//input[@id='txtLastName']");
	By addressField = By.xpath("//input[@placeholder='Address *']");
	By createAcctButton = By.xpath("//input[@id='btnRegister']");
    By signUpLink = By.id("jqSignup");
	By userName=By.xpath("//*[@id='dLabel']/span");
	By loginBtn=By.cssSelector("button#dLabel");
	By myAccountName=By.xpath("(//div[@class='login_sec2_inner']/a)[2]");
	By loginBtn1=By.cssSelector("button#dLabellogin");
	
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}
	
	public boolean accountRegistration(String email,String username ,String password,String confPassword 
			,String firstname, String lastname){
		
		
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(regUserNameField).sendKeys(username);
		driver.findElement(regPasswordField).sendKeys(password);
		driver.findElement(regConfPasswordField).sendKeys(confPassword);
		driver.findElement(firstNameField).sendKeys(firstname);
		driver.findElement(lastNameField).sendKeys(lastname);
		//driver.findElement(addressField).sendKeys(address);
		
		driver.findElement(createAcctButton).click();
		
		driver.findElement(loginBtn).click();
		driver.findElement(myAccountName).click();
		
		elementutil.waitForElementPresent(loginBtn1, 10).click();
		//driver.findElement(loginBtn).click();
		driver.findElement(signUpLink).click();
		
		
		return true;
	}
	
	
	
	
	

}
