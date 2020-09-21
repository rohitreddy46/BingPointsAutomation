package com.bing.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bing.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	// Web elements as object repository
	// email web element
	@FindBy(xpath = "//input[@type = 'email']")
	WebElement email;
	
	// password web element
	@FindBy(xpath = "//input[@type = 'password']")
	WebElement password;
	
	// Next button
	@FindBy(xpath = "//input[@value = 'Next']")
	WebElement next;
	
	// Sign in button
	@FindBy(xpath = "//input[@value = 'Sign in']")
	WebElement sign_in;
	
	//Stay sign in confirmation text
	@FindBy(xpath = "//div[@class = 'row text-title']")
	WebElement stay_signin;
	
	//Dont show this again check box
	@FindBy(xpath = "//input[@name = 'DontShowAgain']")
	WebElement checkbox;
	
	//Yes button
	@FindBy(xpath = "//input[@id = 'idSIButton9']")
	WebElement yesbutton;
	
	//Constructor to initialize the web elements or class variables
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	// Defining Methods or actions from this page
	
	//email sign in
	public void emailSignin(String e) {
		//explicit wait - to wait for the Next button to be clickable
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(email));
		email.sendKeys(e);
		//explicit wait - to wait for the Next button to be clickable
		wait.until(ExpectedConditions.visibilityOf(next));
		next.click();
	}
	
	// password entry
	public void passwordSignin(String p) {
		//explicit wait - to wait for the Next button to be clickable
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(p);
		//explicit wait - to wait for the signin button to be clickable
		wait.until(ExpectedConditions.visibilityOf(sign_in));
		sign_in.click();
	}
	
	public void staySignin() {
		
			System.out.println("stay sign in displayed");
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(yesbutton));
			checkbox.click();
			yesbutton.click();
		
		
		
	}
	
	

}
