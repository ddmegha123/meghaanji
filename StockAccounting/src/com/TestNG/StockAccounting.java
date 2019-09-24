package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class StockAccounting 
{
	
	WebDriver driver;
@BeforeSuite
public void appLaunch() throws Throwable
{
	
	System.setProperty("webdriver.chrome.driver", 
			"D:\\Automationtesting\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://webapp.qedge.com");
			driver.manage().window().maximize();
			Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed());
}
@BeforeTest
public void appLogin()
{
	driver.findElement(By.id("username")).clear();
	driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.id("password")).sendKeys("master");
	driver.findElement(By.id("btnsubmit")).click();
	Assert.assertTrue(driver.findElement(By.id("logout")).isDisplayed());
}
@AfterTest
public void appLogout() throws Throwable
{
	driver.findElement(By.id("logout")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[text()='OK!']")).click();
	Thread.sleep(2000);
	Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed());
}
@AfterSuite
public void appClose() throws Throwable
{
	Thread.sleep(2000);
	driver.close();
}
}
