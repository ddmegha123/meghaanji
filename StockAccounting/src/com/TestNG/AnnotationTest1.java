package com.TestNG;


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
  public void beforMethod()
  {
	System.out.println("before Method Executed");
  }
  @Test
  public void testMethod1()
  {
	  System.out.println("Test Method1 Executed");
  }
  @AfterMethod
  public void afterMethod()
  {
	  System.out.println("After Metod Executed");
  }
  @BeforeClass
  public void beforeClass()
  {
	  System.out.println("before method class Executed");
  }
  @AfterClass
  public void afterClass()
  {
	  System.out.println("After class Executed");
  }
  @BeforeSuite
  public void beforSuite()
  {
	  System.out.println("before suit Executed");
  }
  @AfterSuite
  public void afterSuite()
  {
	  System.out.println("After suite Executed");
  }
}
