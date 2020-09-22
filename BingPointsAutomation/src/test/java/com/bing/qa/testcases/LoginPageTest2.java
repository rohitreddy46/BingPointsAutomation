package com.bing.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import com.bing.qa.base.TestBase;
import com.bing.qa.pages.HomePage;
import com.bing.qa.pages.LoginPage;
import com.bing.qa.util.TestUtil;

public class LoginPageTest2 extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	
	// initializing super constructor inside this constructor
	
	public LoginPageTest2() {
		super();
	}
	
	// calling initialization method to load the browser load and other methods
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		homepage = new HomePage();
		Thread.sleep(3000);
		homepage.signin();
		loginpage = new LoginPage();
	}
	
	@Test
	public void LoginTest() throws InterruptedException {
		
		Thread.sleep(3000);
		loginpage.emailSignin(prop.getProperty("email"));
		Thread.sleep(3000);
		loginpage.passwordSignin(prop.getProperty("password"));
		loginpage.staySignin();
	}
	
	


}