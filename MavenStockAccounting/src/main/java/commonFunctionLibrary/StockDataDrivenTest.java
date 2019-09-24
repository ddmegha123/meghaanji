package commonFunctionLibrary;

import java.io.IOException;

import Utilities.ExelFileUtil;

public class StockDataDrivenTest 
{
   
	public static void main(String[] args) throws Throwable, Throwable 
	{
		ExelFileUtil excel=new ExelFileUtil(); 
		SupplierPage sp=new SupplierPage();
		sp.AppLaunch("http://webapp.qedge.com/login.php");
		sp.appLogin("admin","master");
		
		for(int i=1;i<=excel.rowCount("Sheet1");i++)
		{
			
			String sName=excel.getData("Sheet1", i, 0);
			String addr=excel.getData("Sheet1", i,1);
			String city=excel.getData("Sheet1", i,2);
			String country=excel.getData("Sheet1", i, 3);
			String ContPerson=excel.getData("Sheet1", i, 4);
			String PNo=excel.getData("Sheet1", i, 5);
			String Email=excel.getData("Sheet1", i,6);
			String mNumber=excel.getData("Sheet1", i, 7);
			String Note=excel.getData("Sheet1", i, 8);
			Thread.sleep(2000);
			System.out.println(sName+" "+addr+" "+city+" "+country+" "+ContPerson+" "+PNo+" "+Email+" "+mNumber+" "+Note);
			String Result=sp.openSupp(sName,addr,city,country,ContPerson,PNo,Email,mNumber,Note);
			Thread.sleep(2000);
			excel.setData("Sheet1", i, 9, Result);
			
			
			
			Thread.sleep(2000);
		}
		//sp.appLogout();
		sp.appClose();
		
	}

}
