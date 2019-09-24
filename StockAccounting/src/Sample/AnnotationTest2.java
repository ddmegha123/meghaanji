package Sample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationTest2 
{
	@Test
	public void testMethod2()
	{
		System.out.println("TestMethod2 Executed");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("BeforeTest Executed");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("AfterTest Executed");
	}
}
