package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelData 
{
	public static String getData(String filePath,String sheetName,int rn,int cn)
	{
		try 
		{
			FileInputStream fis = new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rn);
			Cell cell = row.getCell(cn);
			String data = cell.getStringCellValue();
			return data;
		}
		catch (Exception e) 
		{
			return " ";
		}
	}
	
	
	public static int getLastRowNumber(String filePath,String sheetName) 
	{
		try 
		{
			FileInputStream fis = new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			int rowcount = sh.getLastRowNum();
			return rowcount;
		}
		catch (Exception e)
		{

			return -1;
		}
	}

	
	public static short getLastCellNum(String filePath,String sheetName,int rn)
	{
		try 
		{
			FileInputStream fis = new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rn);
			short cellNum = row.getLastCellNum();
			return cellNum;
		} 
		catch (Exception e) 
		{
			return -1;
		}
	}

	
}
