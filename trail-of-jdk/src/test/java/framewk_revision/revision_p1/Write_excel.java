package framewk_revision.revision_p1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Write_excel {
	
	@Test
	public  void write_exl() {
		File fls=new File("C:\\Users\\VipinMishra\\Selenium\\Java\\reading_excel.xlsx");
		
		try {
			FileInputStream fis=new FileInputStream(fls);
			XSSFWorkbook xwbk=new XSSFWorkbook(fis);
			Sheet sht=xwbk.getSheet("S_list");
			Row rw=sht.createRow(10);
			for(int i=1 ; i<=4;i++) {
				switch(i) {
				case 1:
					Cell cl=rw.createCell(i);
					cl.setCellType(Cell.CELL_TYPE_STRING);
					cl.setCellValue("GOTO");
					FileOutputStream FOS=new FileOutputStream("C:\\Users\\VipinMishra\\Selenium\\Java\\reading_excel");
					xwbk.write(FOS);
					System.out.println("text written to excel ");
					FOS.close();
					break;
				case 2:
					Cell cl1=rw.createCell(i);
					cl1.setCellType(Cell.CELL_TYPE_STRING);
				break;
				case 3:
					Cell cl2=rw.createCell(i);
					cl2.setCellType(Cell.CELL_TYPE_STRING);	
					cl2.setCellValue("facebook.com");
					FileOutputStream FOSa=new FileOutputStream("C:\\Users\\VipinMishra\\Selenium\\Java\\reading_excel.xlsx");
					xwbk.write(FOSa);
					System.out.println("text written to excel cell2");
					//FOSa.close();
					break;
					default :
						System.out.println("unable to write anythng after i= 3");
					
						break;
				}
			xwbk.close();}
			
			
		} 
		
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		System.out.println("file nout found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
