package curaTest.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

	Properties pr;
	public ReadConfig() throws FileNotFoundException {
		FileInputStream fs = new FileInputStream("D:\\Selenium Notes\\Selenium practice\\CuraHealthCare\\src\\main\\java\\curaTest\\resources\\GlobalData.properties");
        try{
        	pr=new Properties();
        	pr.load(fs);
        }catch(Exception e) {
        	System.out.println("Exception is "+e.getMessage());
        }
	}
	
	public String getFaclitiy() {
		return pr.getProperty("Facility");
	}
	public String getDate() {
		String date= pr.getProperty("date");
		return date;
	}
	public String getMonth() {
		String month= pr.getProperty("month");
		return month;
	}
}
