package com.bing.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bing.qa.base.TestBase;

public class SearchPage extends TestBase{
	
	@FindBy(xpath = "//input[@id = 'sb_form_q']")
	WebElement searchbar;
	
	public SearchPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void SearchResult(String s) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(searchbar));		
		searchbar.clear();
		searchbar.sendKeys(s);
		searchbar.sendKeys(Keys.ENTER);
	}

}
