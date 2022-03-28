package com.pom.qa.util;

import java.io.IOException;

import com.pom.qa.base.TestBase;

public class ExcelUtils extends TestBase {
	
	public ExcelUtils() throws IOException {
		super();

	}

	/*public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}*/

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 10;

}
