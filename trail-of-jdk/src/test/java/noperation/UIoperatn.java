package noperation;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UIoperatn {
	WebDriver driver;
    public UIoperatn(WebDriver driver){
        this.driver = driver;
    }
	
	public void perfm(String objcttp, Properties p, String objct_val, String oprntype, String value ) throws Exception {
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		
		switch(oprntype.toUpperCase()) {
		case "CLICK":
			driver.findElement(this.getobjct(objcttp, p, objct_val)).click();
			Thread.sleep(10000);
			break;
		case "SETTEXT":
			driver.findElement(this.getobjct(objcttp, p, objct_val)).sendKeys(value);
			break;
		
		case "GOTOURL":
			driver.get(p.getProperty(value));
			break;
		default:
			System.out.println("no such operation is defined in UIoprtn class. please define one ");
			
		}
	}

	private By getobjct(String objcttp, Properties p, String objct_val) throws Exception {
		
		if (objcttp.equalsIgnoreCase("xpath")) {
		return By.xpath(p.getProperty(objct_val));
		}
		else if (objcttp.equalsIgnoreCase("id")) {
			return By.id(p.getProperty(objct_val)); 
		}
		else if (objcttp.equalsIgnoreCase("class")) {
			return By.className(p.getProperty(objct_val)); 
		}
		
		else
        {
            throw new Exception("Wrong object type");
        }
		//return null;
	}
}

