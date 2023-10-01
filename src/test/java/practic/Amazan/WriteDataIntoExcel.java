package practic.Amazan;

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

public class WriteDataIntoExcel {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1: load the file into file input stream in java readable format
		FileInputStream fis = new FileInputStream("./src/test/resources/TestDataAmazan.xlsx");
		
		//Step 2: Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: get inside the sheet
		Sheet sh = wb.getSheet("Qdex");
		
		//Step 4: get the used row
		Row rw = sh.getRow(1);
		
		//Step 5: create a cell
		Cell ce = rw.createCell(2);
		
		//Step 6: write data into cell
		ce.setCellValue("ProductName");
		
		//Step 7: Open the file in java write format and write into workbook
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestDataAmazan.xlsx");
		wb.write(fos);
		System.out.println("Data added");
		wb.close();
		
		
	}

}
