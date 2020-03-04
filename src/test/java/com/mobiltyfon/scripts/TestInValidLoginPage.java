package com.mobiltyfon.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mobiltyfon.generic.BaseTest;
import com.mobiltyfon.generic.FwUtils;
import com.mobiltyfon.pages.LoginPage;

public class TestInValidLoginPage extends BaseTest{
	 private static Logger log= LogManager.getLogger(TestLoginPage.class.getName());
		
	@Test(dataProvider = "testData")
	public void validLoginPage(String userName,String password) throws InterruptedException 
	{
		LoginPage lp=new LoginPage(driver);
		
		//lp.linksInLoginPage(driver);
		Thread.sleep(2000);
		lp.SetuserNameTextBox(userName);
	
		lp.SetpasswordTextBox(password);
	
		lp.signIn();
		log.error("user name and password are incorrect and failed to sign in");
		lp.errMsg();
		
	}	
	@DataProvider(name="testData")
		public Object[][]testData() throws EncryptedDocumentException, FileNotFoundException, IOException
		{
		
			int row=FwUtils.xl_Row_Count(excelPath, "InvalidLoginPage");
			Object[][]data=new Object[row][2];
			
			for(int i=0;i<row;i++)
			{
		
			data[i][0]=FwUtils.read_XL_Data(excelPath, "InvalidLoginPage", i, 0);
			data[i][1]=FwUtils.read_XL_Data(excelPath, "InvalidLoginPage", i, 1);
		
		}
			return data;
		
	}
}

