package selenium_chrome;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel2_read_col_row {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet wsheet;
	
	public static Object[][] readdata() throws IOException
	{
		
		FileInputStream fis = new FileInputStream("C:\\Project\\excel\\selenium_excel1.xlsx");
		wb = new XSSFWorkbook(fis);
		wsheet =wb.getSheetAt(0);
		XSSFRow row = wsheet.getRow(0);
		int rowcount = wsheet.getPhysicalNumberOfRows();
		int colcount=row.getLastCellNum();
		
		Object[][] Data = new Object[rowcount][colcount];
		for(int i=0;i<rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				String value =wsheet.getRow(i).getCell(j).getStringCellValue();
				Data[i][j]=value;
			}
		}
		
		return Data;
	}
	
}
	
	
	