package com.bing.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bing.qa.base.TestBase;
import com.bing.qa.pages.HomePage;
import com.bing.qa.pages.LoginPage;
import com.bing.qa.pages.SearchPage;
import com.bing.qa.util.TestUtil;

public class SearchPageTest extends TestBase {
	
	LoginPage loginpage;
	SearchPage searchpage;
	HomePage homepage;
	
	
	public SearchPageTest() {
		
		super(); // initializes the TestBase constructor which initiates the properties file
		
	}
	
	@BeforeSuite
	public void setup() throws InterruptedException {
		initialization();
		homepage = new HomePage();
		Thread.sleep(10000);
		homepage.signin();
		Thread.sleep(5000);
		loginpage = new LoginPage();
		Thread.sleep(5000);
		loginpage.emailSignin(prop.getProperty("email"));
		Thread.sleep(5000);
		loginpage.passwordSignin(prop.getProperty("password"));
		Thread.sleep(5000);
		loginpage.staySignin();
		//searchpage = new SearchPage();
		searchpage = homepage.search();
	}
	
	
	@DataProvider
	public Iterator<String> getTestData (){
		ArrayList<String> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	@Test(dataProvider = "getTestData")
	public void searchTest(String SearchItems) throws InterruptedException {
		
		searchpage.SearchResult(SearchItems);
		Thread.sleep(5000);
		
	}
	
	
	  @AfterSuite
	  public void tearDown() { 
		  driver.close(); 
		  }
	 
	
	
}
