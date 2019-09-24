package com.TestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExelFileUtil;

public class DataDrivenTestNG extends StockAccounting
{
	
	@Test(dataProvider="getData")
	public void supplierCreation(String sName,String add,String city,String country,String cPerson,String pNumber,String email,String mNumber,String note) throws Throwable
	{
		
		driver.findElement(By.linkText("Supplier")).click();
		driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
		Thread.sleep(2000);
		String exp_data=driver.findElement(By.id("x_Supplier_Number")).getAttribute("value");
		System.out.println(exp_data);
		driver.findElement(By.id("x_Supplier_Name")).sendKeys(sName);
		driver.findElement(By.name("x_Address")).sendKeys(add);
		driver.findElement(By.id("x_City")).sendKeys(city);
		driver.findElement(By.id("x_Country")).sendKeys(country);
		driver.findElement(By.id("x_Contact_Person")).sendKeys(cPerson);
		driver.findElement(By.name("x_Phone_Number")).sendKeys(pNumber);
		driver.findElement(By.id("x__Email")).sendKeys(email);
		driver.findElement(By.id("x_Mobile_Number")).sendKeys(mNumber);
		driver.findElement(By.id("x_Notes")).sendKeys(note);
		//scroll down page
		/*Actions pageDown=new Actions(driver);
		pageDown.sendKeys(Keys.PAGE_DOWN).build().perform();*/
		driver.findElement(By.id("btnAction")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='OK!']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@class='ajs-button btn btn-primary']")).click();
		//validation
		if(driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[2]/div[2]/div/button")).isDisplayed())
		{
			driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[2]/div[2]/div/button")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("psearch")).clear();
			driver.findElement(By.id("psearch")).sendKeys(exp_data);
			driver.findElement(By.id("btnsubmit")).click();
		}else
		{
			Thread.sleep(3000);
			driver.findElement(By.id("psearch")).clear();
			driver.findElement(By.id("psearch")).sendKeys(exp_data);
			driver.findElement(By.id("btnsubmit")).click();
		}
		
		String act_data=driver.findElement(By.xpath("//*[@id='el1_a_suppliers_Supplier_Number']/span")).getText();
		
		System.out.println(act_data);
		
		Assert.assertEquals(exp_data, act_data);
		
		
		driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[2]/div[2]/div/button")).click();
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		
		
		Object [] [] data=new Object[2][9];
		ExelFileUtil excel=new ExelFileUtil();
		for (int i = 0; i<=excel.rowCount("Sheet1"); i++) 
		{
			//int colcnt=excel.colCount("Sheet1", 1);
			for (int j = 0; j <excel.colcount("Sheet1", 1); j++) 
			{
				data[i][j]=excel.getData("Sheet1", i, j);
			}
			
		}
		return data;
		
	}
}
