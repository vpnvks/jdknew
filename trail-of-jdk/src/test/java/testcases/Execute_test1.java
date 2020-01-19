package testcases;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import framewk_revision.revision_p1.Read_excel;
import io.github.bonigarcia.wdm.WebDriverManager;
import noperation.Read_objt;
import noperation.UIoperatn;

public class Execute_test1 {
	
	

	@Test
	
public void execute() {
		WebDriverManager.firefoxdriver().setup();	
		WebDriver driver = new FirefoxDriver();
		Read_excel rdexl=new Read_excel();
		UIoperatn optn=new UIoperatn(driver);
		Read_objt rdobj=new Read_objt();
		String filePath="C:\\Users\\VipinMishra\\Selenium\\Java";
		
		try {
			Sheet sh=rdexl.readexcel(filePath, "reading_excel.xlsx", "S_list");
			int rw_cnt=sh.getLastRowNum()-sh.getFirstRowNum();
			Properties p=rdobj.get_obj("nobject.properties");
			//String str1=System.getProperty("user.dir")+"\\"+"nobject\\nobject.properties";
			//System.out.println(str1);
			for (int a=1;a<=rw_cnt;a++) {
				Row row = sh.getRow(a);
				//int j=row.getCell(0).toString().length();
				
			     if(row.getCell(0).toString().length()==0) {
					System.out.println("test case step is "+row.getCell(1).toString());
					String oprntype=row.getCell(1).toString();
					optn.perfm(row.getCell(3).toString(), p, row.getCell(2).toString(), oprntype, row.getCell(4).toString());
				}
				else {
					System.out.println("executing test case "+ sh.getRow(a).getCell(0).toString() );
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("excel file not found in Execute.test1.class");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
