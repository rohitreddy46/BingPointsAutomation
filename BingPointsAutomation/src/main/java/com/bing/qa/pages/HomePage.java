package com.bing.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bing.qa.base.TestBase;
import com.bing.qa.util.TestUtil;

public class HomePage extends TestBase {
	
	//page factory - Object Repository
	
	@FindBy(id = "id_l")
	WebElement signin;
	
	@FindBy(xpath = "//*[@id = 'b_logo']")
	WebElement binglogo;
	
	//Constructor to initialize web elements of this webpage
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//Methods to define different actions in the login page
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateBingImage() {
		return binglogo.isDisplayed();
	}
	
	public LoginPage signin() {
		
		signin.sendKeys(Keys.ENTER);
		return new LoginPage();

	}
	

}
