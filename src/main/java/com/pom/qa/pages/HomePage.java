package com.pom.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.qa.base.TestBase;

public class HomePage extends TestBase {
	
	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}
@FindBy(xpath ="//span[contains(text(),'Kinnaree parmar')]")
WebElement userNameLabel;

@FindBy(xpath="//img[@class='logo img-responsive']")
WebElement logo;

@FindBy(xpath="//a[@class='logout']")
WebElement signoutbtn;
	
	
	
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public boolean verifyYourLogo(){
		return logo.isDisplayed();
	}
	public boolean verifysignoutbtn(){
		return signoutbtn.isDisplayed();
	}

}
