package com.qa.wildcart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.wildcart.base.BaseTest;
import com.qa.wildcart.utilites.Constants;

public class HomePageTest extends BaseTest {
	
	@BeforeClass
	public void homepagesetup() {
		loginpage.isSignUpButtonExists();
		homepage=loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyHomePageTitle() {
		String title=homepage.getHomePageTitle();
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
	
	}
	@Test(priority=2)
	public void verifyLoggedUserTest() {
		String accountname=homepage.getLoggedAccountName();
		Assert.assertEquals(accountname,prop.getProperty("accountname"));
	}
	@Test(priority=3)
	public void verifyProdListCount() {
		int count=homepage.getSectionCount();
		Assert.assertEquals(count,8);
		
	}
//	@Test(priority=4)
	public void verifyProdList() {
		Assert.assertEquals(homepage.getSectionList(),Constants.getSectionIteamsList());
	}
	
	
	
	
	
	
	
	
	
	
	

}
