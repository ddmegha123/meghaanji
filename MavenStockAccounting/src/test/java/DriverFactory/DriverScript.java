package DriverFactory;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.mongodb.diagnostics.logging.Logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.*;
import org.apache.commons.io.FileUtils;

import java.io.*;
import CommonFunLibrary.FunctionLibrary;
import Utilities.ExelFileUtil;


public class DriverScript 
{
  WebDriver driver;
  ExtentReports report;
  ExtentTest logger;
  public void startTest() throws Throwable, Throwable
  {
	  ExelFileUtil excel=new ExelFileUtil();

	  System.out.println(excel.rowCount("MasterTestCases"));
	  //MasterTestCases sheet
	  for(int i=1; i<=excel.rowCount("MasterTestCases");i++)
	  {
		  String ModuleStatus="";
		  if(excel.getData("MasterTestCases", i, 2).equalsIgnoreCase("Y"))
		  {
			  //Define module name
			  
			  String TCModule=excel.getData("MasterTestCases", i,1);
			  report =new ExtentReports("C:\\Users\\megha.m\\ERP_Project\\AutomationTesting\\MavenStockAccounting\\Reports\\"+TCModule+""+FunctionLibrary.generateDate()+".png");
			  int rowcount=excel.rowCount(TCModule);
			  //TCModule sheet
			  for(int j=1;j<=rowcount;j++)
			  {
				  String Description=excel.getData(TCModule, j, 0);
				  String Object_Type=excel.getData(TCModule, j, 1);
				  System.out.println(Object_Type);
				  String Locator_Type=excel.getData(TCModule, j, 2);
				  String Locator_Value=excel.getData(TCModule, j,3);
				  String Test_Data=excel.getData(TCModule, j,4);
				 
				  try
				  {
				  if(Object_Type.equalsIgnoreCase("StartBrowser"))
				  {
					  driver=FunctionLibrary.startBrowser(driver);
				  }
				  if(Object_Type.equalsIgnoreCase("OpenApplication"))
				  {
					  FunctionLibrary.openApplication(driver);
				  }
				  if(Object_Type.equalsIgnoreCase("typeAction"))
				  {
					  FunctionLibrary.typeAction(driver, Locator_Type, Locator_Value, Test_Data);
				  }
				  if(Object_Type.equalsIgnoreCase("clickAction"))
				  {
					  FunctionLibrary.clickAction(driver, Locator_Type, Locator_Value);
				  }
				  if(Object_Type.equalsIgnoreCase("waitForElement"))
				  {
					  FunctionLibrary.waitForElement(driver, Locator_Type, Locator_Value, Test_Data);
				  }
				  if(Object_Type.equalsIgnoreCase("pageDown"))
				  {
					  FunctionLibrary.pageDown1(driver);
				  }
				  if(Object_Type.equalsIgnoreCase("captureData"))
					{
						FunctionLibrary.captureData(driver, Locator_Type, Locator_Value);
					}
				  if(Object_Type.equalsIgnoreCase("tableValidation"))
				  {
					  FunctionLibrary.tableValidation(driver, "6");
				  }
//				  if(Object_Type.equalsIgnoreCase("tableValidation")) 
//				  {
//					  FunctionLibrary.stockIteams(driver, Locator_Type, Locator_Value, data);
//				  }
//			
				  
				  if(Object_Type.equalsIgnoreCase("closeBrowser"))
				  {
					  FunctionLibrary.closeBrowser(driver);
				  }
				  
				  excel.setData(TCModule, j, 5, "Pass");
				  ModuleStatus="true";
			      }catch(Exception e)
				  { 
			    	  //Status update in TCmodule Sheet "fail"
			    	  
			    	excel.setData(TCModule, j, 5, "FAIL");
			    	logger.log(LogStatus.FAIL, Description+"     FAIL");
			    	ModuleStatus="FALSE";
			    	File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			    	FileUtils.copyFile(scrFile , new File("C:\\Users\\megha.m\\ERP_Project\\AutomationTesting\\MavenStockAccounting\\ScreenShots"+TCModule+""+FunctionLibrary.generateDate()+".png"));
			    	
			    	break;
			      }
			  }
			  if(ModuleStatus.equalsIgnoreCase("true"))
			  {
				  //Status update in masterTesteCases Sheet "Pass"
				  excel.setData("MasterTestCases", i, 3, "Pass");
			  }else
				  if(ModuleStatus.equalsIgnoreCase("false"))
				  {
					  //Status update in masterTesteCases Sheet "fail"
					  excel.setData("MasterTestCases", i, 3, "FAIL");
				  }
			  report.endTest(logger);
			  report.flush();
		  }
		  else
		  {
			  excel.setData("MasterTestCases", i, 3, "Not Executed");
		  }
			      
		  
	  }
  }
}
