package Sample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationTest1 
{
@BeforeMethod
public void beforeMethod()
{
	System.out.println("BeforeMethod Executed");
}
@Test
public void testMethod1()
{
	System.out.println("TestMethod1 Executed");
}

@AfterMethod
public void afterMethod()
{
	System.out.println("AfterMethod Executed");
}
@BeforeClass
public void beforeClass()
{
	System.out.println("BeforeClass Executed");
}
@AfterClass
public void afterClass()
{
	System.out.println("AfterClass Executed");
}
@BeforeSuite
public void beforeSuite()
{
	System.out.println("BeforeSuite Executed");
}
@AfterSuite
public void afterSuite()
{
	System.out.println("AfterSuite Executed");
}
}
