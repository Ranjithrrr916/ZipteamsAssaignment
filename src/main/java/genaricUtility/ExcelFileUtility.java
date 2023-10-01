package genaricUtility;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	

	public String readDataFromExcel(String SheetName, int rowNo, int celNo) throws  IOException
	{
		FileInputStream fis=new FileInputStream(IContantsUtility.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		String value=wb.getSheet(SheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
		wb.close();
		return value;
	}
	
	
	
	
	public void writeIntoExcel(String SheetName, int rowNo, int celNo, String value) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream(IContantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row rw = sh.createRow(rowNo);
		Cell cel = rw.createCell(celNo);
		cel.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IContantsUtility.excelFilePath);
		wb.write(fos);
		wb.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
