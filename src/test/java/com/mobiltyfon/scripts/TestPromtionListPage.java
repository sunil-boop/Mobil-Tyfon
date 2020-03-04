package com.mobiltyfon.scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.mobiltyfon.generic.BaseTest;
import com.mobiltyfon.generic.FwUtils;
import com.mobiltyfon.pages.CreatePromotionPage;
import com.mobiltyfon.pages.HomePage;
import com.mobiltyfon.pages.LoginPage;
import com.mobiltyfon.pages.PromtionListPage;

public class TestPromtionListPage extends BaseTest {
	private static Logger log = LogManager.getLogger(TestLoginPage.class.getName());

	@Test
	public void promtionListpage() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		log.info("LoginPage intiailized sucessfully");
		// lp.linksInLoginPage(driver);
		String userName = FwUtils.read_XL_Data(excelPath, "validLoginPage", 1, 0);
		log.info("read the test data from the exel sheet username");
		String password = FwUtils.read_XL_Data(excelPath, "validLoginPage", 1, 1);

		log.info("read the test data from the excel sheet password");
		lp.SetuserNameTextBox(userName);
		log.info("enter the user name sucessfully");
		lp.SetpasswordTextBox(password);
		log.info("Enter the password sucessfully");
		lp.signIn();
		log.info("we sucessfully logged in");
		HomePage hp = new HomePage(driver);
		Thread.sleep(2000);
		hp.clickOnPromotions();
		PromtionListPage pp = new PromtionListPage(driver);
		pp.newCampaignFeature();
	
	}

}
