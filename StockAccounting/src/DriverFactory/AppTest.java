package DriverFactory;

import org.testng.annotations.Test;

public class AppTest
{
	@Test
	public void kickStart() throws Throwable
	{
		DriverScript ds=new DriverScript();
		DriverScript1234 ms=new DriverScript1234();
		try
		{
			ms.startTest();
			//ds.startTest();
		}catch(Exception e)
		{
			e.printStackTrace();
		
		}
	}

}
