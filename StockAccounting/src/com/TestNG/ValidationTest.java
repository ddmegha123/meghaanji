package com.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationTest 
{
	
	@Test
	public void validation()
	{
		String data="Selenium";
		String data1="Selenium Training";
		
		if(data.equals(data1))
		{
			System.out.println("Equal");
		}else
		{
			System.out.println("Not Equal");
		}
		
		Assert.assertEquals(data, data1);
		Assert.assertEquals(12,13);
		
		//Assert.assertTrue(driver.findElement("")).isDispalyed);
	}
	}


