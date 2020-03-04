package com.mobiltyfon.scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.mobiltyfon.generic.BaseTest;
import com.mobiltyfon.generic.FwUtils;
import com.mobiltyfon.pages.HomePage;

public class TestHomePage extends BaseTest {
	 private static Logger log= LogManager.getLogger(TestLoginPage.class.getName());
	@Test
	public void homePage() throws InterruptedException
	{
		TestLoginPage tl=new TestLoginPage();
		tl.validLoginPage();
		
		
		
		
		
		
	}

}
