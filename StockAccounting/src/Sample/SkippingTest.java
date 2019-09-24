package Sample;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkippingTest 
{

@Test
public void witoutSkip()
{
	System.out.println("witoutSkip");
}
@Test
public void skipTest()
{
	throw new SkipException("Skip the Test Cases is not ready");
}

}
