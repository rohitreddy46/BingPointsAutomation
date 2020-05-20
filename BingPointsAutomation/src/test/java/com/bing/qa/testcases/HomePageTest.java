package com.bing.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bing.qa.base.TestBase;
import com.bing.qa.pages.HomePage;
import com.bing.qa.pages.LoginPage;
import com.bing.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	
	public HomePageTest() {
		
		super(); // initializes the TestBase constructor which initiates the properties file
		
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
	}
	
	@Test(priority =1)
	public void HomePage_Test() throws InterruptedException {
		Thread.sleep(3000);
		
		loginpage = homepage.signin();
	}
	



}
