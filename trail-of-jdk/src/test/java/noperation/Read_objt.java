package noperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Read_objt {
Properties prp=new Properties();	

FileInputStream fis;
public Properties get_obj(String objfilnm) {
try {
	File fs=new File (System.getProperty("user.dir")+"\\src\\test\\java\\nobject\\"+objfilnm);
	 fis=new FileInputStream(fs);
	prp.load(fis);
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	System.out.println("property file not found check Read_objt class");
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return prp;	
}
}