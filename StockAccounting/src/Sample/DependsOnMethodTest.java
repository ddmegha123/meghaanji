package Sample;

import org.testng.Assert;
import org.testng.annotations.Test;



public class DependsOnMethodTest 
{
@Test
public void urlLaunch()
{
	System.out.println("urlLaunch");
	
	Assert.fail();
}
@Test(dependsOnMethods="urlLaunch",alwaysRun=true)
public void enterCredentials()
{
	System.out.println("enter valid Credentials");
}
@Test(dependsOnMethods="enterCredentials")
public void login()
{
	System.out.println("login");
}
}
