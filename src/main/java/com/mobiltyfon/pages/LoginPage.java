package com.mobiltyfon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiltyfon.generic.FwUtils;

public class LoginPage {
	
	

	@FindBy(xpath = "//input[@id='userName']")
	private WebElement unTb;
	@FindBy(xpath = "//input[@id='passWord']")
	private WebElement upTb;
	@FindBy(xpath = "//input[@title='Sign In']")
	private WebElement signInButton;
	@FindBy(tagName = "//a")
	private WebElement links;
	@FindBy(xpath="//td[@class='small mandatory']")private WebElement errMsg;
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void SetuserNameTextBox(String un) {
		unTb.sendKeys(un);
	}

	public void SetpasswordTextBox(String pw) {
		upTb.sendKeys(pw);
	}

	public void signIn() {
		signInButton.click();
		signInButton.isDisplayed();

	}
	public void errMsg()
	{
		System.out.println("error msg is displayed"+errMsg.isDisplayed());
		driver.switchTo().frame(0);
		driver.switchTo().defaultContent();
	}
	

	public void linksInLoginPage(WebDriver driver) throws InterruptedException {

		
		List<WebElement> links = driver.findElements(By.tagName("a"));
	    int numberOfLinks = driver.findElements(By.tagName("a")).size();
		System.out.println("number of links present in the login page is" + links.size());
	
		for(int i=0;i<numberOfLinks;i++)
		{
		//is empty returns true condition become false and it will not print the test
			if(!links.get(i).getText().isEmpty()) {
			
			System.out.println(links.get(i).getText());
			driver.findElements(By.tagName("a")).get(i).sendKeys(Keys.CONTROL,Keys.ENTER);

		}}
	}
	

//		Set<String> a=driver.getWindowHandles();
//		Iterator<String> it=a.iterator();
//		while(it.hasNext())
//		{
//			driver.switchTo().window(it.next());
//			System.out.println(driver.getTitle());
//		}
 

			}

		
	

