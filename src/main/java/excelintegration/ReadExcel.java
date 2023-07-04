package excelintegration;

import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static String[][] readexcel(String fileName) throws IOException {
		
 XSSFWorkbook wbook = new XSSFWorkbook("./data/"+fileName+".xlsx");
 XSSFSheet sheet = wbook.getSheetAt(0);
		
		int rowcount = sheet.getLastRowNum();
	    int cellcount = sheet.getRow(0).getLastCellNum();
	
 String[][] data = new String[rowcount] [cellcount];
 for(int i=1; i<= rowcount; i++) {
	XSSFRow row = sheet.getRow(i);
	for(int j=0; j< cellcount; j++) {
	String stringCellValue = row.getCell(j).getStringCellValue();
		System.out.println(stringCellValue);
		data[i-1][j] = stringCellValue;
			}
		}
		wbook.close();
		return data;
	}

}
