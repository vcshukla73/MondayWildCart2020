package com.qa.wildcart.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.wildcart.base.BaseTest;
import com.qa.wildcart.utilites.Constants;
import com.qa.wildcart.utilites.ExcelUtil;



public class RegisterPageTest extends BaseTest {
	
	
	@BeforeClass
	public void signUpSetup() {
		registerpage=loginpage.dosignup();
		
	}
	
	@DataProvider
	public Object[][] getRegisterData() {
		Object data[][]=ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;
	}
	
	@Test(dataProvider="getRegisterData")
	public void userRegisterationTest(String email,String username,String password,String confpassword
			,String firstname,String lastname,String address)  {
		registerpage.accountRegistration(email,username,password, confpassword,firstname,lastname,address);
	}	
	
	
	
		
	
	
	
}
