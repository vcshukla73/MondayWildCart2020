package com.qa.wildcart.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.wildcart.base.BaseTest;

public class MyTest extends BaseTest {
	
	@BeforeClass
	public void homepagesetup() {
		loginpage.isSignUpButtonExists();
		homepage=loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		myaccount=homepage.domyAccount();
	}

	
	@Test
	public void verifyAllAccountOptions() {
		myaccount.getAllAccountOtions();
		//Assert  H W -----
		
	}
	
	
	//@Test
	public void verifyAllLinksWorking() {
		   // please check all links ---
		
	}
	
	
	
}
