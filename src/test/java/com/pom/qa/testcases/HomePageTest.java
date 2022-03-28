package com.pom.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.qa.base.TestBase;
import com.pom.qa.pages.HomePage;
import com.pom.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	public HomePageTest() throws IOException {
		super();

	}

	HomePage hp;
	LoginPage lp;

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		lp = new LoginPage();
		hp = lp.login(prop.getProperty("correctun"), prop.getProperty("correctpwd"));
	}

	@Test
	public void verifyUsername() {
		Assert.assertEquals(hp.verifyCorrectUserName(), true);

	}

	@Test
	public void homepagetitle() {
		Assert.assertEquals(hp.verifyHomePageTitle(), "My account - My Store");
	}

	@Test
	public void logoPresenttest() {
		Assert.assertEquals(hp.verifyYourLogo(), true);
	}
	
	@Test
	public void signoutbtntest() {
		Assert.assertEquals(hp.verifysignoutbtn(), true);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
