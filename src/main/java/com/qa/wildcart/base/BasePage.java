package com.qa.wildcart.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.wildcart.utilites.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	private WebDriver driver;
	private Properties prop;
	public static String highlight;
	public OptionsManager optionsManager;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	
	// this method is intialize the browser & driver
	
	public WebDriver initl_driver(String browsername) {
		
		highlight=prop.getProperty("highlight");
		optionsManager = new OptionsManager(prop);

		System.out.println("Browser name "+browsername);
		
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver();
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));

		}else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver=new FirefoxDriver();
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));

		}else if(browsername.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			//driver=new SafariDriver();
			tlDriver.set(new SafariDriver());

		
	}else
	{
		System.out.println("broser not found please pass the proper name");
	}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
//	driver.manage().window().maximize();
//	driver.manage().deleteAllCookies();
	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//driver.get(prop.getProperty("url"));
	return getDriver();

	//return driver;	

}
	/**
	 * getDriver using ThreadLocal
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
public Properties init_prop() {
	prop=new Properties();
	
	try {
		//C:\Users\vaibhav\eclipse-workspace\MondayPOM2020WildCart\src\main\java\com\qa\wildcart\properties
		FileInputStream ip= new FileInputStream("C:\\Users\\vaibhav\\eclipse-workspace\\MondayPOM2020WildCart\\src\\main\\java\\com\\qa\\wildcart\\properties\\config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
 return prop;	
	
}

public String getScreenshot() {
	
	File src=((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);	
	String path=System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
	File destination=new File(path);
	
	try {
		FileUtils.copyFile(src, destination);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return path;
}





	
	

}
