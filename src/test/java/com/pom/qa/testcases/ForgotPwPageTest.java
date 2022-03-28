package com.pom.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.qa.base.TestBase;
import com.pom.qa.pages.ForgotPwPage;
import com.pom.qa.pages.LoginPage;

public class ForgotPwPageTest extends TestBase{
	
	public ForgotPwPageTest() throws IOException {
		super();
	}

	ForgotPwPage fp;
	LoginPage lp;

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		fp = new ForgotPwPage();
		lp = new LoginPage();
		fp= lp.forgotpassword();
	}

	@Test
	public void forgotpwstextverify() {
		String text1 = fp.forgotpwdtext();
		Assert.assertEquals(text1, "FORGOT YOUR PASSWORD?");
	}

	@Test
	public void BackButtonverify() {
		Assert.assertEquals(fp.BackButtonPresent(), true);
	
	}
	@Test
	public void emailboxverify() {
		Assert.assertEquals(fp.emailboxPresent(), true);
	
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
