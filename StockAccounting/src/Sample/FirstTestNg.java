package Sample;

import org.testng.annotations.Test;

public class FirstTestNg 
{
@Test()
public void vasu()
{
	System.out.println("Sample Test");
}
@Test(priority=2)
public void second()
{
	System.out.println("second Test");
}
}
