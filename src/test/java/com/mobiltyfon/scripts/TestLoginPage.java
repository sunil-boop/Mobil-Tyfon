package com.mobiltyfon.scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.mobiltyfon.generic.BaseTest;
import com.mobiltyfon.generic.FwUtils;
import com.mobiltyfon.pages.LoginPage;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class TestLoginPage extends BaseTest {
	 private static Logger log= LogManager.getLogger(TestLoginPage.class.getName());
	
	@Test
	public void validLoginPage() throws InterruptedException 
	{
//		//specify baseURI
//		
//		RestAssured.baseURI="http://sunilkp kantharajapura";
//		//request object
//		RequestSpecification request=RestAssured.given();
//		
//		// response object
		
		LoginPage lp=new LoginPage(driver);
		log.info("LoginPage initialized successfully");
		//lp.linksInLoginPage(driver);
		String title = FwUtils.read_XL_Data(excelPath, "validLoginPage", 1, 2);
		FwUtils.verfiyTitle(driver, title);
		String userName = FwUtils.read_XL_Data(excelPath, "validLoginPage", 1, 0);
		log.info("read the test data from the exel sheet user name");
		String password = FwUtils.read_XL_Data(excelPath, "validLoginPage", 1, 1);
		log.info("read the test data from the excel sheet password");
		lp.SetuserNameTextBox(userName);
		log.info("enter the user name successfully");
		lp.SetpasswordTextBox(password);
		log.info("Enter the password successfully");
		lp.signIn();
//		log.info("we sign in the application succesfuly");
//		driver.close();
	
		
	}

}
