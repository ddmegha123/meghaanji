package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitStatement
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automationtesting\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://Gmail.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("identifierId")).sendKeys("vasu@Qedgetech.com");
		driver.findElement(By.xpath("//*[@id='identifierNext']/div[2]")).click();
		driver.findElement(By.name("password"));
	}

}
