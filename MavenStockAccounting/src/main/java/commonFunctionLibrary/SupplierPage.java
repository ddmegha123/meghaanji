package commonFunctionLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SupplierPage
{
	
		WebDriver driver;
		String res;
		public String AppLaunch(String url)
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\megha.m\\ERP_Project\\AutomationTesting\\MavenStockAccounting\\ExecutableFiles\\chromedriver.exe");
		    driver=new ChromeDriver();
		    driver.get(url);
		    driver.manage().window().maximize();
		    if(driver.findElement(By.id("username")).isDisplayed())
		    {
		    	res="Launch pass";
		    }else
		    {
		    	res="Launch Fail";
		    }
			return res;
		}
		public String appLogin(String Username,String Passwod) 
		{
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys(Username);
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys(Passwod);
			driver.findElement(By.id("btnsubmit")).click();
			if(driver.findElement(By.id("logout")).isDisplayed())
			{
				res="Login pass";
			}else
			{
				res="Login fail";
			}
			
			return res;
		}
		//open supplier page
		public String openSupp(String sName,String addr,String City,String country,String ContPerson,String PNo,String Email,String MNo,String Note) throws InterruptedException
		{
			
			driver.findElement(By.id("mi_a_suppliers")).click();
			driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
			Thread.sleep(2000);
			
			String exp_data=driver.findElement(By.id("x_Supplier_Number")).getAttribute("value");
			System.out.println(exp_data);
			
			driver.findElement(By.id("x_Supplier_Name")).sendKeys(sName);
			driver.findElement(By.id("x_Address")).sendKeys(addr);
			driver.findElement(By.id("x_City")).sendKeys(City);
			driver.findElement(By.id("x_Country")).sendKeys(country);
			driver.findElement(By.id("x_Contact_Person")).sendKeys(ContPerson);
			driver.findElement(By.id("x_Phone_Number")).sendKeys(PNo);
			driver.findElement(By.id("x__Email")).sendKeys(Email);
			driver.findElement(By.id("x_Mobile_Number")).sendKeys(MNo);
		    driver.findElement(By.id("x_Notes")).sendKeys(Note);
		   
		    
		 //Scroll down page
		    Actions pageDown=new Actions(driver);
		    pageDown.sendKeys(Keys.PAGE_DOWN).build().perform();
		    Thread.sleep(2000);
		    driver.findElement(By.id("btnAction")).click();
		    Thread.sleep(2000);
		    
		//handling popup
		    driver.findElement(By.xpath("//*[text()='OK!']")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("(//*[text()='OK'])[6]")).click();
		    Thread.sleep(2000);
		//validation
		    if(driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[2]/div[2]/div/button")).isDisplayed())
		      {
		    	  driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[2]/div[2]/div/button")).click();
		    	  driver.findElement(By.id("psearch")).clear();
		    	  driver.findElement(By.id("psearch")).sendKeys(exp_data);
		    	  driver.findElement(By.id("btnsubmit")).click();
		      }else
		      {
		    	  Thread.sleep(2000);
		    	  driver.findElement(By.id("psearch")).clear();
		    	  driver.findElement(By.id("psearch")).sendKeys(exp_data);
		    	  driver.findElement(By.id("btnsubmit")).click();
		      }
		    String act_data=driver.findElement(By.xpath("//*[@id='el1_a_suppliers_Supplier_Number']/span")).getText();
		    System.out.println(act_data);
		          
		    if(exp_data.equals(act_data))
		    {
		    	res="pass1";
		    }else
		    {
		    	res="Fail1";
		    }
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[2]/div[2]/div/button")).click();
		   return res;
		}
		//Stock items
		public String stockCate(String cateName) throws InterruptedException
		{
			Actions a=new Actions(driver);
			a.moveToElement(driver.findElement(By.id("mi_a_stock_items"))).build().perform();
		    a.moveToElement(driver.findElement(By.id("mi_a_stock_categories"))).click().build().perform();
			
		    driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
		    driver.findElement(By.id("x_Category_Name")).sendKeys("CateName");
		    driver.findElement(By.id("btnAction")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[text()='OK!']")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("(//*[text()='OK'])[6]")).click();
			Thread.sleep(2000);
			
			if(driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[2]/div[2]/div/button")).isDisplayed())
			{
				driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[2]/div[2]/div/button")).click();
				driver.findElement(By.xpath("//*[@id='psearch']")).sendKeys(cateName);
				driver.findElement(By.id("btnsubmit")).click();
			}else
			{
				driver.findElement(By.xpath("//*[@id='psearch']")).sendKeys(cateName);
				driver.findElement(By.id("btnsubmit")).click();
			}
			String act_data=driver.findElement(By.xpath("//*[@id='el1_a_stock_categories_Category_Name']/span")).getText();
			if(cateName.equals(act_data))
			{
				res="Pass";
			}	else
			{
				res="fail";
			}	
			
			
			Thread.sleep(2000);
			return res;
		}
		public void appLogout()
		{
			driver.close();
		}
		
		public void appClose()
		{
			
			driver.close();
		}

		public static void main(String[] args) throws InterruptedException 
		{
			SupplierPage sp=new SupplierPage();
			
			String Launch=sp.AppLaunch("http://webapp.qedge.com/login.php");
			System.out.println(Launch);
			
			String Login=sp.appLogin("admin","master");
			System.out.println(Login);
			
			String Supplier=sp.openSupp("Vivo", "Nagpue", "Hingna","Indea", "SureshBabu", "762078", "xzys@gmail.com", "9822551689", "i am succesfuly enter the details about supplier");
			System.out.println(Supplier);
			
			String mousemove=sp.stockCate("vivo");
			System.out.println(mousemove);
			sp.appClose();
			

		}

	

}
