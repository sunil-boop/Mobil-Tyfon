package com.mobiltyfon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePromotionPage {
	@FindBy(xpath = "//input[@name='property(Campaign Name)']")
	private WebElement promotionName;
	@FindBy(xpath = "//input[@name='property(Start Date)']")
	private WebElement startdate;
	@FindBy(xpath = "Calendar")
	private WebElement calenderIcon;
	
	
	
	public CreatePromotionPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public void clickOnCalender()
	{
		calenderIcon.click();
	}
	
	
	
	
	
	
	
	
	
}
