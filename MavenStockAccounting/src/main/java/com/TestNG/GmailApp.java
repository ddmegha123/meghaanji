package com.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailApp
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\megha.m\\ERP_Project\\AutomationTesting\\MavenStockAccounting\\ExecutableFiles\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
	}
}
