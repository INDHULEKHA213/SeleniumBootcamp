package login_using_excel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LearnExcel {

	public static String[][] excelintegration(String fileName) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook("./data/"+fileName+".xlsx");
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		 int rowcount = sheet.getLastRowNum();
		 int cellcount = sheet.getRow(0).getLastCellNum();
		 
		 String[] [] data = new String [rowcount] [cellcount];
		 
		 for(int i=1; i<=rowcount; i++) {
			 XSSFRow row = sheet.getRow(i);
			 for(int j=0; j<cellcount; j++)  {
				String stringCellValue = row.getCell(j).getStringCellValue();
				data[i-1] [j] = stringCellValue;
			 }
		 }
workbook.close();
return data;
	}


}
