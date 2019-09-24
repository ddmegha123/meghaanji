package Sample;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class GroupTest1 
{
	@Test(groups="reg")
	public void firstMethod()
	{
		System.out.println("Reg1 Testing");
	}
	@Test(groups="reg")
	public void secondMethod()
	{
		System.out.println("Reg2 Testing");
	}
	@Test(groups="smoke")
	public void thridMethod()
	{
		System.out.println("smoke Testing");
	}
}
