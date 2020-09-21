package com.bing.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.bing.qa.util.TestUtil;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		
		//code for reading file 
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\rohit\\git\\BingPointsAutomation\\BingPointsAutomation\\src\\main\\java\\com\\bing\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		
		//code for initializing the browser
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("FireFox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}

}
