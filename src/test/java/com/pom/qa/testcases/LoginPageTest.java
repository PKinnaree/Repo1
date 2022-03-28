package com.pom.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.qa.base.TestBase;
import com.pom.qa.pages.ForgotPwPage;
import com.pom.qa.pages.HomePage;
import com.pom.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	ForgotPwPage fp;

	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		lp = new LoginPage();
		fp= new ForgotPwPage();
	}

	@Test
	public void loginTitleTest() {
		Assert.assertEquals(lp.verifyLoginpagetitle(), "Login - My Store");
	}

	@Test
	public void registerlinkTextTest() {
		Assert.assertEquals(lp.reglinkText(), "ALREADY REGISTERED?");
	}

	@Test
	public void reglinkDispalyedTest() {
		Assert.assertEquals(lp.regLinkavailable(), true);
	}

	@Test
	public void emailboxpresenttest() {
		Assert.assertEquals(lp.emailboxcheck(), true);
	}

	@Test
	public void pwdboxPresentTest() {
		Assert.assertEquals(lp.pwdboxcheck(), true);
	}

	@Test
	public void SuccessfulLogInTest() throws IOException {
		hp = lp.login(prop.getProperty("correctun"), prop.getProperty("correctpwd"));
		Assert.assertEquals(hp.verifyCorrectUserName(), true);
	}

	@Test
	public void LoginFromKeyboard() throws IOException {
		hp = lp.loginwithEnter(prop.getProperty("correctun"), prop.getProperty("correctpwd"));
		Assert.assertEquals(hp.verifyCorrectUserName(), true);
	}

	@Test
	public void LoginWithIncorrectData() {
		lp.loginwithIncorrectData(prop.getProperty("wrongemail"), prop.getProperty("wrongpwd"));
		Assert.assertEquals(lp.errorMsgVerify(), "Authentication failed." );
	}

	@Test
	public void WronEmailcorrectPwdTest() {
		lp.loginwithIncorrectData(prop.getProperty("wrongemail"), prop.getProperty("correctpwd"));
		Assert.assertEquals(lp.errorMsgVerify(), "Authentication failed.");
	}

	@Test
	public void CorrectEmailwrongPwdTest() {
		lp.loginwithIncorrectData(prop.getProperty("correctun"), prop.getProperty("wrongpwd"));
		Assert.assertEquals(lp.errorMsgVerify(), "Authentication failed.");
	}

	@Test
	public void emptyEmailcorrectPwdTest() {
		lp.loginwithIncorrectData(prop.getProperty("emptyemail"), prop.getProperty("correctpwd"));
		Assert.assertEquals(lp.errorMsgVerify(),"Invalid email address.");
	}

	@Test
	public void emptyEmailwronPwdTest() {
		lp.loginwithIncorrectData(prop.getProperty("emptyemail"), prop.getProperty("wrongpwd"));
		Assert.assertEquals(lp.errorMsgVerify(), "Invalid email address.");
	}

	@Test
	public void correctEmailemptyPwdTest() {
		lp.loginwithIncorrectData(prop.getProperty("correctun"), prop.getProperty("emptypwd"));
		Assert.assertEquals(lp.errorMsgVerify(), "Invalid password.");
	}

	@Test
	public void wronEmailemtyPwdTest() {
		lp.loginwithIncorrectData(prop.getProperty("wrongemail"), prop.getProperty("emptypwd"));
		Assert.assertEquals(lp.errorMsgVerify(), "Invalid password.");
	}

	@Test
	public void invalidEmailcorrectPwdTest() {
		lp.loginwithIncorrectData(prop.getProperty("invalidemail"), prop.getProperty("correctpwd"));
		Assert.assertEquals(lp.errorMsgVerify(), "Invalid email address.");
	}

	@Test
	public void invalidEmailwronPwdTest() {
		lp.loginwithIncorrectData(prop.getProperty("invalidemail"), prop.getProperty("wrongpwd"));
		Assert.assertEquals(lp.errorMsgVerify(), "Invalid email address.");
	}
	
	@Test
	public void emptyEmailEmptyPwdTest() {
		lp.loginwithIncorrectData(prop.getProperty("emptyemail"), prop.getProperty("emptypwd"));
		Assert.assertEquals(lp.errorMsgVerify(), "An email address required.");
	}
	
	@Test
	public void emptyEmailinvalidPwdTest() {
		lp.loginwithIncorrectData(prop.getProperty("emptyemail"), prop.getProperty("invalidpwd"));
		Assert.assertEquals(lp.errorMsgVerify(), "An email address required.");
	}
	
	@Test
	public void invalidEmaiemptyPwdTest() {
		lp.loginwithIncorrectData(prop.getProperty("invalidemail"), prop.getProperty("emptypwd"));
		Assert.assertEquals(lp.errorMsgVerify(), "Invalid email address.");
	}
	
	@Test
	public void loginWithEnterbtnCorrectEmailemptypwdTest() throws IOException {
		hp = lp.loginwithEnter(prop.getProperty("correctun"), prop.getProperty("emptypwd"));
		Assert.assertEquals(lp.errorMsgVerify(), "Password is required.");
	}
	
	
	
	@Test
	public void verifyForgotPwdTest() {
		lp.verifyforgotpwdlink();
	}

	 @Test
	public void forgotpwdLinkTest() throws IOException {
		fp= lp.forgotpassword();
		Assert.assertEquals(fp.forgotpwdtext(), "FORGOT YOUR PASSWORD?");
	}

	 @Test
	public void signinbtnEnableTest() {
		Assert.assertEquals(lp.signinbtnenabled(), true);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
