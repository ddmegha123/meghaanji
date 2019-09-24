package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class StockAccounting1
{
  private static final CharSequence Passwod = null;
private static final CharSequence Username = null;
WebDriver driver;
  @BeforeSuite
  public void AppLaunch()
  {
	  System.setProperty("webdriver.chrome.driver", "D:\\Automationtesting\\chromedriver.exe");
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
		
  }
//  @AfterTest
//  public void appLogout()
//  {
//	  driver.findElement(By.id("logout")).click();
//	  driver.findElement(By.xpath("/html/body/div[19]/div[2]/div/div[4]/div[2]/button[1]")).click();
//	  Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed());
//  }
//  @AfterSuite
//  public void appClose()
//  {
//	  driver.close();
//  }
  
}
