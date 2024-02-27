package UtilityFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class WriteData {
	
	public void writeData(String sheetName, List<String> values ,int rowNo, int colNo) throws IOException {
		
		
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\Testdata\\DocData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file); 
		
		
		try {
		
			XSSFSheet sheet= workbook.getSheet(sheetName);	
			for(int i = rowNo; i<values.size(); i++)
			{
				
				if(sheet.getRow(i)==null)
				{
					sheet.createRow(i);
				}
				XSSFRow row =sheet.getRow(i);   
				
				row.createCell(colNo).setCellValue(values.get(i));
							
			}
		}
		catch(Exception e)
		{
			XSSFSheet sheet =	workbook.createSheet(sheetName);
			for(int i = rowNo; i<values.size(); i++) 
			{
				
				if(sheet.getRow(i)==null)
				{
					sheet.createRow(i);
				}
				XSSFRow row =sheet.getRow(i);   
				
				row.createCell(colNo).setCellValue(values.get(i));
							
			}
		}
		
		 
		
		 
		FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"\\Testdata\\DocData.xlsx");
		workbook.write(fo);		
		file.close();
		fo.close();

	}


}
