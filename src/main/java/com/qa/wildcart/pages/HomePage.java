package com.qa.wildcart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.wildcart.utilites.Constants;
import com.qa.wildcart.utilites.ElementUtil;

public class HomePage {
	private WebDriver driver;
	private ElementUtil elementutil;
	
	//this is locator
	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
		
	}
		
	By username=By.xpath("//button[@id='dLabel']");
	By prodList=By.xpath("//div[@class='product_box_outer']//h5");
	By myAccountName=By.xpath("(//div[@class='login_sec2_inner']/a)[1]");
	
	public String getHomePageTitle() {
		return elementutil.doGetPageTitleWithContains(10, Constants.LOGIN_PAGE_TITLE);
	}
	
	public String getLoggedAccountName() {
		elementutil.waitForElementPresent(username, 10);
		return elementutil.doGetText(username);
		
	}
	
	public int getSectionCount() {
		return elementutil.getElements(prodList).size();
	}
	
	public List<String> getSectionList() {
		List<String> sectionlist=new ArrayList<String>();
		List<WebElement> sectionlist1=elementutil.getElements(prodList);
		for (WebElement webElement : sectionlist1) {
			System.out.println(webElement.getText());
			sectionlist.add(webElement.getText());
		}
		
		return sectionlist;
	}
	
public MyAccount domyAccount() {
	
	elementutil.clickWhenReady(username, 10);
	elementutil.clickWhenReady(myAccountName, 10);
	
	return new MyAccount(driver);
	
	
}
	
	
	
	

}
