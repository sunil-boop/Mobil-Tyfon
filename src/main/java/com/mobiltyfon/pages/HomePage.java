package com.mobiltyfon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//a[contains(text(),'Campaign')]")
	private WebElement promotions;
	@FindBy(xpath = "//a[contains(text(),'Potentials')]")
	private WebElement potentials;
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	private WebElement connections;
	@FindBy(xpath = "//a[contains(text(),'Leads')]")
	private WebElement leader;
	@FindBy(xpath = "//a[contains(text(),'Accounts')]")
	private WebElement ledger;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnPromotions() {
		promotions.click();
	}

	public void clickOnPotentials() {
		potentials.click();
	}
	public void clickOnConnections() {
		connections.click();
	}
	public void clickOnLeader() {
		leader.click();
	}
	public void clickOnLedger() {
		ledger.click();
	}
	
	
	
	
	
	
	
	
	

}