package framewk_revision.revision_p1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_excel {
	
	public Sheet readexcel(String filePath,String fileName,String sheetName) throws FileNotFoundException {
		File fs=new File(filePath+"\\"+fileName);
		FileInputStream FIS;
		Workbook wrbk=null;
		Sheet sht=null;
try {
	FIS =new FileInputStream(fs);
	String str=fileName.substring(fileName.indexOf("."));
	if (str.contains("xlsx")) {
	wrbk=new XSSFWorkbook(FIS);}	
	else {
	wrbk=new HSSFWorkbook(FIS);	
	}
	sht=wrbk.getSheet(sheetName);
	
} catch (IOException e) {
	// TODO Auto-generated catch block
	System.out.println("excel file not found");
}
		return sht;
		
	}

}
