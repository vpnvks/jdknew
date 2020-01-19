package testcases;

import org.testng.annotations.Test;

public class Switch_trail {

	@Test
	public void swichtr() {
		for (int i=0; i<3; i++) {
		
			switch(i) {	
		case 1: 
				System.out.println("monday");
				break;
		case 2:
			System.out.println("tuesday");
			break;
			default:
				System.out.println("nothing");
			break;
		}}
	}
}
