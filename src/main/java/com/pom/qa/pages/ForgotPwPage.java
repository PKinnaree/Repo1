package com.pom.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.qa.base.TestBase;

public class ForgotPwPage extends TestBase{
	
	@FindBy(xpath="//h1[@class='page-subheading']")
	WebElement frpwdtext;
	
	@FindBy(xpath="//a[@title='Back to Login']")
	WebElement backbtn;

	@FindBy(id="email")
	WebElement emailbox;
	
	



	   public ForgotPwPage() throws IOException {
		   super();
		   PageFactory.initElements(driver,this);
				}
		
		public String forgotpwdtext() {
			return frpwdtext.getText();
		}
		
		public boolean BackButtonPresent() {
			return backbtn.isDisplayed();
			}
		
		public boolean emailboxPresent() {
			return emailbox.isDisplayed();
			}
		

}
