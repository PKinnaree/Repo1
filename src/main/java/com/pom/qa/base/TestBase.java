package com.pom.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pom.qa.util.ExcelUtils;

;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public TestBase() throws IOException {
		
		try {
			prop = new Properties();
			FileInputStream f = new FileInputStream("C:\\Users\\HP WORLD\\Desktop\\selenium\\Selenium_Workspace\\PageObject\\src\\main\\java\\com\\pom\\qa\\config\\config.properties");
			prop.load(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() throws IOException {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\HP WORLD\\Desktop\\selenium\\SeleniumJars\\geckodriver.exe");
			driver= new FirefoxDriver();
			}else if ( browserName.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver","C:\\Users\\HP WORLD\\Downloads\\chromedriver.exe");
			driver= new ChromeDriver();
			}
		
		driver.manage().timeouts().pageLoadTimeout(ExcelUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(ExcelUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}

}
