package com.qa.wildcart.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.wildcart.base.BasePage;
import com.qa.wildcart.base.BaseTest;
import com.qa.wildcart.pages.LoginPage;
import com.qa.wildcart.testlisteners.TestAllureListener;
import com.qa.wildcart.utilites.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(TestAllureListener.class)
@Epic("Epic 100 : define Login page features...")
@Story("Us 1 define the login page class features with titile ,link,login")
public class LoginPageTest extends BaseTest {
	
	
	@Description("verify signup link test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1)
	public void verifySignUpLinkTest() {

		Assert.assertEquals(loginpage.isSignUpButtonExists(), true);

	}
	@Description("verify Login page title test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void verifyPageTitle() {
		String title = loginpage.getLoginPageTitle();
		System.out.println("Title is " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);

	}
	@Description("verify Login test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 3)
	public void loginTest() {
		loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));

	}

}
