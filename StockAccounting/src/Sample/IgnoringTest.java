package Sample;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class IgnoringTest 
{
	@Test(invocationCount=5)
	public void test1()
	{
		System.out.println("test1");
	}
	@Test(enabled=false)
	public void test2()
	{
		System.out.println("test2");
	}
}
