package com.TestNG;

import org.testng.annotations.Test;

public class FirstTestNg 
{
  @Test
  public void megha()
  {
	  System.out.println("Samole test");
  }
  @Test(priority=2)
  public void second()
  {
	System.out.println("Second Test");
  }
}
