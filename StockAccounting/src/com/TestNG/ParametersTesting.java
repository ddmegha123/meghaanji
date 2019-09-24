package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParametersTesting 
{
	private static final CharSequence Passwod = null;

	@Test(dataProvider="getData")
	public void appLogin(String userName,String password)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automationtesting\\chromedriver.exe");
		WebDriver  driver=new ChromeDriver();
		driver.get("http://webapp.qedge.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("btnsubmit")).click();
		
		driver.close();
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="admin";
		data[0][1]="master";
		data[1][1]="admin";
		data[1][2]="master";
	    return data;
		
	}

}
