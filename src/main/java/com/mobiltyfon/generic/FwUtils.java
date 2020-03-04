package com.mobiltyfon.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * 
 * @author Sunil K P
 *
 */



public class FwUtils  {
	public  static String read_XL_Data(String excelPath, String sheet, int rn, int cn) {
		String data = "";
	
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(excelPath));
			data = wb.getSheet(sheet).getRow(rn).getCell(cn).toString();
			//System.out.println(data);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return data;

	}
	/**
	 * This method is used to count number of row presents in the excel sheet
	 * @param excelPath
	 * @param sheet
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws EncryptedDocumentException 
	 */

	public static  int xl_Row_Count(String excelPath, String sheet) throws EncryptedDocumentException, FileNotFoundException, IOException {
		int rowCount = 0;
		
			Workbook wb = WorkbookFactory.create(new FileInputStream(excelPath));
			rowCount = wb.getSheet(sheet).getLastRowNum();
			System.out.println("number of rows in the sheet is"+"   "+rowCount);
		
		return rowCount;
	}
	/**
	 * This method is used to Read the Data From Excel Sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param reportPath
	 * @return
	 */
	public static int write_xl_data(String sheet,int row,int cell,String reportPath)
	{
		int v=0;
		try {
		Workbook wb = WorkbookFactory.create(new FileOutputStream(reportPath));
		wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(v);
		wb.write(new FileOutputStream(reportPath));
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return v;	
	}
	/**
	 * This method is used to TakeScreenShot
	 * @param driver
	 * @param path
	 */
	
	
	public static void  takeScreenshot(WebDriver driver,String path) 
	{
		try {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		 FileUtils.copyFile(src,new File(path));
	}
	catch(Exception e)
		{
		e.printStackTrace();
		}
	
	}	
	/**
	 * This Method Is Used To Verify Title Of The Page
	 * @param driver
	 * @param expected
	 * @param ExpectedTitle
	 * @throws InterruptedException
	 */
	
	public static void verfiyTitle( WebDriver driver,String expectedTitle) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(expectedTitle));
		String actual=driver.getTitle();
		Assert.assertEquals(actual, expectedTitle);
		System.out.println(expectedTitle+" is displayed==>"+expectedTitle);
		 	
		
	}
}