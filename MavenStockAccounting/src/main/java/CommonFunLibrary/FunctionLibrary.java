package CommonFunLibrary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.PropertyFileUtil;



public class FunctionLibrary
{
 static WebDriver driver;
 //Start Browser
 public static WebDriver startBrowser(WebDriver driver) throws Throwable
 {
	 if(PropertyFileUtil.getValueForKey("Browser").equals("ie"))
	 {
		 System.setProperty("webdriver.ie.driver", "");
		 driver=new InternetExplorerDriver();
	 }else
		 if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("Chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver","C:\\Users\\megha.m\\ERP_Project\\AutomationTesting\\MavenStockAccounting\\ExecutableFiles\\chromedriver.exe");
		     driver=new ChromeDriver();
		 }
	 return driver;
 }

 //OpenApplication
  public static void openApplication(WebDriver driver) throws Throwable
 {
	  driver.get(PropertyFileUtil.getValueForKey("URL"));
	  driver.manage().window().maximize();
 }
  //clickAction
  public static void clickAction(WebDriver driver,String locatorType,String locatorValue)
  {
	  if(locatorType.equalsIgnoreCase("id"))
	  {
		  driver.findElement(By.id(locatorValue)).click();
	  }else
		  if(locatorType.equalsIgnoreCase("name"))
		  {
			  driver.findElement(By.name(locatorValue)).click();
		  }else
			  if(locatorType.equalsIgnoreCase("xpath"))
			  {
				  driver.findElement(By.xpath(locatorValue)).click();
			  }
  }
   //typeAction
  public static void typeAction(WebDriver driver,String locatorType,String locatorValue,String data)
  {
	if(locatorType.equalsIgnoreCase("id"))
	{
		driver.findElement(By.id(locatorValue)).clear();
		driver.findElement(By.id(locatorValue)).sendKeys(data);
	}else
		if(locatorType.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(locatorValue)).clear();
			driver.findElement(By.name(locatorValue)).sendKeys(data);
		}else
			if(locatorType.equalsIgnoreCase("xpath"))
			{
				driver.findElement(By.xpath(locatorValue)).clear();
				driver.findElement(By.xpath(locatorValue)).sendKeys(data);
			}
    }
  //Open Suplier Creation
  public static void SuplierCreation(WebDriver driver,String locatorType,String locatorValue,String data)
  {
	  if(locatorType.equalsIgnoreCase("id"))
	  {
		  driver.findElement(By.id(locatorValue)).clear();
		  driver.findElement(By.id(locatorValue)).sendKeys(data);
	  }else
		  if(locatorType.equalsIgnoreCase("name"))
		  {
			  driver.findElement(By.name(locatorValue)).clear();
			  driver.findElement(By.name(locatorValue)).sendKeys(data);
		  }else
			  if(locatorType.equalsIgnoreCase("xpath"))
			  {
				  driver.findElement(By.xpath(locatorValue)).clear();
				  driver.findElement(By.xpath(locatorValue)).sendKeys(data);
			  }
  }
  //closeBrowser
  public static void closeBrowser(WebDriver driver)
  {
	  driver.close();
  }
  //waitForElement
  public static void waitForElement(WebDriver driver,String locatorType,String locatorValaue,String time)
  {
	  WebDriverWait myWait=new WebDriverWait(driver,Integer.parseInt(time));
	  if(locatorType.equalsIgnoreCase("id"))
	  {
		  myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValaue)));
	  }else
		  if(locatorType.equalsIgnoreCase("name"))
		  {
			  myWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValaue)));
		  }else
			  if(locatorType.equalsIgnoreCase("xpath"))
			  {
				
				myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValaue)));
			  }
  }
//scroll down page
	public static void pageDown1(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	
	//CaptureData
	public static void captureData(WebDriver driver,String locatorType,String locatorValue) throws IOException
	{
		String data="";
		
		if(locatorType.equalsIgnoreCase("id"))
		{
			data=driver.findElement(By.id(locatorValue)).getAttribute("value");
		}else
			if(locatorType.equalsIgnoreCase("name"))
			{
				data=driver.findElement(By.name(locatorValue)).getAttribute("value");
			}else
				if(locatorType.equalsIgnoreCase("xpath"))
				{
					data=driver.findElement(By.xpath(locatorValue)).getAttribute("value");
				}
		
		FileWriter fw=new FileWriter("C:\\Users\\megha.m\\ERP_Project\\AutomationTesting\\MavenStockAccounting\\CaptureData\\Data.txt");
		
		BufferedWriter bw=new BufferedWriter(fw);
		
		bw.write(data);
		bw.flush();
		bw.close();
		
	}
	
	//TableValidation
	public static void tableValidation(WebDriver driver,String column) throws Throwable
	{
		//Reading the data from txt file
		FileReader fr=new FileReader("C:\\Users\\megha.m\\ERP_Project\\AutomationTesting\\MavenStockAccounting\\PropertyFile\\Environment.properties");
		BufferedReader br=new BufferedReader(fr);
		String exp_data=br.readLine();
		
		//converting String value into integer
		int colNum=Integer.parseInt(column);
		
		if(driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("Search.panel"))).isDisplayed())
		{
			driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("Serach.panel"))).click();
			Thread.sleep(3000);
			driver.findElement(By.id(PropertyFileUtil.getValueForKey("Search.Box"))).click();
			driver.findElement(By.id(PropertyFileUtil.getValueForKey("Search.Box"))).sendKeys(exp_data);
			driver.findElement(By.id(PropertyFileUtil.getValueForKey("Search.Button"))).click();
		}
		//Supplier webtable
		WebElement webtable=driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("webtable")));
		//row count
		List<WebElement> rows=webtable.findElements(By.tagName("tr"));
		
		for(int i=1;i<=rows.size();i++)
		{
			//Capturing supplier number
			String act_data=driver.findElement(By.xpath("//*[@id='ewContentColumn']"+"/div[3]/from/div//"+"table[@id='tbl_a_supplierslist']/tbody/tr["+i+"]/td["+colNum+"]"+"/div/span")).getText();
			
			System.out.println(act_data);
			//vali8dation
	       Assert.assertEquals(act_data, exp_data);
	       break;
					
		}
	}
	public static String generateDate()
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY_MM_DD_SS");
		return sdf.format(date);
		}
	//For StckAccounting
	 public static void stockIteams(WebDriver driver,String locatorType,String locatorValue,String data)
	  {
		  if(locatorType.equalsIgnoreCase("id"))
		  {
			  driver.findElement(By.id(locatorValue)).clear();
			  driver.findElement(By.id(locatorValue)).sendKeys(data);
		  }else
			  if(locatorType.equalsIgnoreCase("name"))
			  {
				  driver.findElement(By.name(locatorValue)).clear();
				  driver.findElement(By.name(locatorValue)).sendKeys(data);
			  }else
				  if(locatorType.equalsIgnoreCase("xpath"))
				  {
					  driver.findElement(By.xpath(locatorValue)).clear();
					  driver.findElement(By.xpath(locatorValue)).sendKeys(data);
				  }
	  }
//public static void tableValidation

//  public static void main(String[] args) throws Throwable 
//  {
//	  FunctionLibrary.startBrowser(driver);
//	  FunctionLibrary.openApplication(driver);
//	  FunctionLibrary.typeAction(driver, "id", "username","admin");
//	  FunctionLibrary.waitForElement(driver, "id", "password","10");
//	  FunctionLibrary.typeAction(driver, "name", "password", "master");
//	  FunctionLibrary.waitForElement(driver, "name", "password","10");
//	 // FunctionLibrary.SuplierCreation(driver, "id", "pa", data);
	 
	// }
}
