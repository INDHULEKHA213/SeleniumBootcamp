package learnExcel;

import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static void main(String[] args) throws IOException {
		

		XSSFWorkbook workbook = new XSSFWorkbook("./data/Personalinfo.xlsx");
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rowcount = sheet.getLastRowNum();
	    int cellcount = sheet.getRow(0).getLastCellNum();
	
		for(int i=0; i<= rowcount; i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j=0; j< cellcount; j++) {
			String stringCellValue = row.getCell(j).getStringCellValue();
				System.out.println(stringCellValue);
			}
		}
	}

}
