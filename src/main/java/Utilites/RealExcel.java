package Utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class RealExcel {
	@DataProvider(name="orangeHrmLogin")
public String[][] loginExcelData() throws Exception {

	FileInputStream fis = new FileInputStream("./TestData/LoginTestData.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet("LoginData");
	int noofRows = sheet.getPhysicalNumberOfRows();
	int noofCol = sheet.getRow(0).getLastCellNum();
	
	String[][] data = new String[noofRows-1][noofCol];
	
	for(int i=0;i<noofRows-1;i++) {
		for(int j=0;j<noofCol;j++) {
			DataFormatter df = new DataFormatter();
			data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			
		}
	}
	
	return data;
}

}
