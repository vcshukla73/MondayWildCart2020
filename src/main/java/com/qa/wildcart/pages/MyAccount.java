package com.qa.wildcart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.wildcart.utilites.ElementUtil;

public class MyAccount {
	private WebDriver driver;
	private ElementUtil elementutil;
	
	public MyAccount(WebDriver driver) {
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
		
	}
	
	
	
	By username=By.xpath("//button[@id='dLabel']");
	
	By myAccountName=By.xpath("(//div[@class='login_sec2_inner']/a)[1]");
	
	By allOptionTag=By.xpath("//div[@class='myaccount_list']//div[@class='col-sm-12 col-lg-3 col-md-3']/a");
	
	
	
	public List<String> getAllAccountOtions() {
		
		List<String> returnlist=new ArrayList<String>();
				
		List<WebElement> allelements=elementutil.getElements(allOptionTag);
		
		for (WebElement webElement : allelements) {
			
			System.out.println(webElement.getText());
			returnlist.add(webElement.getText());
			
		}
		
	  return returnlist;	
		
		
		
	}
	
	
	
	
	
	
	

}
