package selenium_chrome;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class My_first_excel {
	
	
	
	
  @Test
  public void testexcel () throws IOException {
	  FileInputStream fis = new FileInputStream("C:\\Project\\excel\\selenium_excel1.xlsx");
	  XSSFWorkbook wb = new XSSFWorkbook(fis);
	  XSSFSheet sheet1 = wb.getSheetAt(0);
	  int rowCount = sheet1.getPhysicalNumberOfRows();
	  System.out.println(rowCount);
	  XSSFRow row1 = sheet1.getRow(0);
	  int colcount = row1.getLastCellNum();
	  System.out.println(colcount);
  
	  
	  for (int i=0;i<rowCount;i++)
	  {
		  String username = sheet1.getRow(i).getCell(0).getStringCellValue();
		  System.out.println(username);
		  String pswd = sheet1.getRow(i).getCell(1).getStringCellValue();
		  System.out.println(pswd);
	  }
  }
  
  }
