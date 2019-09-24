package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExelFileUtil
{
	Workbook wb;
	public ExelFileUtil() throws IOException, Throwable, Throwable
	{
		FileInputStream fin=new FileInputStream("C:\\Users\\megha.m\\ERP_Project\\AutomationTesting\\MavenStockAccounting\\TestInputs\\InputSheet1.xlsx");
		wb=WorkbookFactory.create(fin);
	}
    //Row count
	public int rowCount(String sheetname)
	{
		return wb.getSheet(sheetname).getLastRowNum();
	}
	//Cloumn count
	public int colcount(String sheetname,int row)
	{
		return wb.getSheet(sheetname).getRow(row).getLastCellNum();
	}
	//Reading data
	public String getData(String sheetname,int row,int col)
	{
		String data="";
		if(wb.getSheet(sheetname).getRow(row).getCell(col).getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			int celldata=(int)wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
			data=String.valueOf(celldata);
		}else
		{
			data=wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
		}
		return data;
	}
	//Storing data into Excel Sheet pass or Fail and not Executed
	public void setData(String sheetname,int row,int col,String Result) throws IOException
	{
		Sheet sh=wb.getSheet(sheetname);
		Row rownum=sh.getRow(row);
		Cell cellno=rownum.createCell(col);
		cellno.setCellValue(Result);
		if(Result.equalsIgnoreCase("Pass"))
		{
			//Create cell style
			CellStyle style=wb.createCellStyle();
		    //createFont
			Font font=wb.createFont();
			//Apply color to text
			font.setColor(IndexedColors.GREEN.index);
			//Apply Bold to text
			font.setBold(true);
			//Set font
			style.setFont(font);
			//Set Cell  Style
			rownum.getCell(col).setCellStyle(style);
		}else
		if(Result.equalsIgnoreCase("Fail"))
		{
			//Create cell style
			CellStyle style=wb.createCellStyle();
		    //createFont
			Font font=wb.createFont();
			//Apply color to text
			font.setColor(IndexedColors.RED.index);
			//Apply Bold to text
			font.setBold(true);
			//Set font
			style.setFont(font);
			//Set Cell  Style
			rownum.getCell(col).setCellStyle(style);
		}else
		
			if(Result.equalsIgnoreCase("Not Executed"))
			{
				//Create cell style
				CellStyle style=wb.createCellStyle();
			    //createFont
				Font font=wb.createFont();
				//Apply color to text
				font.setColor(IndexedColors.BLUE.index);
				//Apply Bold to text
				font.setBold(true);
				//Set font
				style.setFont(font);
				//Set Cell  Style
				rownum.getCell(col).setCellStyle(style);
			}
		
		FileOutputStream fout=new FileOutputStream("C:\\Users\\megha.m\\ERP_Project\\AutomationTesting\\MavenStockAccounting\\TestOutputs\\OutputSheet1.xlsx");
		wb.write(fout);
		fout.close();
		
	}
	public static void main(String[] args) throws Throwable, Throwable
	{
		ExelFileUtil excel=new ExelFileUtil();
		System.out.println(excel.rowCount("Sheet1"));
		System.out.println(excel.colcount("Sheet1", 1));
		System.out.println(excel.getData("Sheet1", 1, 1));
		
		excel.setData("Sheet1", 1,2, "Pass");
		
		excel.setData("Sheet1", 2, 2, "Fail");
		excel.setData("Sheet1", 3, 2, "Not Executed");
	}

}
