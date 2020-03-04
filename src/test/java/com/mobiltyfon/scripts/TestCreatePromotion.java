package com.mobiltyfon.scripts;

import org.testng.annotations.Test;

import com.mobiltyfon.generic.BaseTest;
import com.mobiltyfon.pages.CreatePromotionPage;

public class TestCreatePromotion extends BaseTest {
	
	
	@Test
	public void createPromotion() throws InterruptedException {
		TestPromtionListPage tp=new TestPromtionListPage();
		tp.promtionListpage();
		CreatePromotionPage cp=new CreatePromotionPage(driver);
		cp.clickOnCalender();
	}

}
