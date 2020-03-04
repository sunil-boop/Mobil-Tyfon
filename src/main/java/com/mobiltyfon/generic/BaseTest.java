 package com.mobiltyfon.generic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements IAutoConstant {
	

	
	
	static {
		System.setProperty("CHROME_KEY", "CHROME_VALUE");
		System.setProperty("GECKO_KEY", "GECKO_VALUE");
	}
	public static WebDriver driver;
	private static int pass = 0;
	private static int fail = 0;
	private static String name;
	
	@BeforeClass(alwaysRun = true)
	@Parameters("browser")

	public void selectBrowser(String browser) {
		
		
//		DesiredCapabilities ds=new DesiredCapabilities();
//		ds.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
	}

	@BeforeMethod(alwaysRun = true)

	public void openApplicstion() {
		driver.manage().timeouts().implicitlyWait(IMW, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(PLT, TimeUnit.SECONDS);
		driver.get(URL);

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		
			int status = result.getStatus();
			if (status == 1) {
				pass++;
			} 
			else if (status > 1) {
				fail++;
		//name=result.getName();
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(src, new File("./photo/"+result.getName()+".png"));
			} catch (IOException e) {

				e.printStackTrace();
			}}
			System.out.println("Number of tests passed is:" + pass);
			System.out.println("Number of tests failed is:" + fail);

	}
}
