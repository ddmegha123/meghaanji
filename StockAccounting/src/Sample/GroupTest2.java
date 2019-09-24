package Sample;

import org.testng.annotations.Test;

public class GroupTest2 
{
	@Test(groups="reg")
	public void regMethod()
	{
		System.out.println("Reg3 Testing");
	}
	@Test(groups="reg")
	public void reg1Method()
	{
		System.out.println("Reg4 Testing");
	}
	@Test(groups="smoke")
	public void smokeMethod()
	{
		System.out.println("smoke1 Testing");
	}
}
