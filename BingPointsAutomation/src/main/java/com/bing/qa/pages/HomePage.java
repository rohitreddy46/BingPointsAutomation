package com.bing.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bing.qa.base.TestBase;


public class HomePage extends TestBase {
	
	//page factory - Object Repository
	
	@FindBy(xpath = "//*[@id = 'id_l']")
	WebElement signin;
	//(id = "id_l")
	
	@FindBy(xpath = "//*[@id = 'b_logo']")
	WebElement binglogo;
	
	@FindBy(xpath = "//input[@id = 'sb_form_q']")
	WebElement searchbox;
	
	
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
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(signin));
		signin.sendKeys(Keys.ENTER);
		return new LoginPage();

	}
	
	public SearchPage search() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(searchbox));
		searchbox.sendKeys("'");
		searchbox.sendKeys(Keys.ENTER);
		return new SearchPage();
		
		
	}
	

}
