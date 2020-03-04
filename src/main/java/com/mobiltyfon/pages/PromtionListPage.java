package com.mobiltyfon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PromtionListPage {
	@FindBy(xpath="(//a[contains(text(),'Edit')])[2]")private WebElement edit;
	@FindBy(xpath="//input[@value='New Campaign']")private WebElement newCampaign;
	
	
	
	public PromtionListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void edit()
	{
		edit.click();
	}
	
	public void newCampaignFeature()
	{
		newCampaign.click();
	}
	
	
	
	
	
	
	
	
	
	

}
