package curaTest.pageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import javax.swing.text.html.HTMLDocument.HTMLReader.CharacterAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import CuraHealth.AbstractComponents.AbstractComponent;

public class BookAppointment  extends AbstractComponent  {

	WebDriver driver;
	public BookAppointment(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(id="combo_facility")
	WebElement sel;
	
	@FindBy(css=".input-group-addon")
	WebElement clkdtbox;
	
	@FindBy(css=".datepicker-switch")
	WebElement clkmon;
	@FindBy(xpath="//div[@class='datepicker-months']/table[@class='table-condensed']/thead/tr[2]/th[2]")
	WebElement clkmon2;
//	@FindBy(xpath="//div[@class='datepicker-days']/table/thead/tr[2]/th[2]")
//	WebElement clkMon;
	@FindBy(css="span[class*='month']")
	List<WebElement> selMon;
	
//	@FindBy(xpath="//div[@class='datepicker-days']/table/tbody/tr[3]/td[3]")
//	WebElement selday;
	@FindBy(css="td[class='day']")
	List<WebElement> selday;

	@FindBy(xpath="//th[text()='2023']")
	WebElement clkDate;
	
	@FindBy(xpath="//span[text()='2019']")
	WebElement selDate;
	
	@FindBy(id="radio_program_medicaid")
	WebElement heprg;
	
	@FindBy(id="txt_comment")
	WebElement cmt;
	
	@FindBy(id="btn-book-appointment")
	WebElement bokbtn;
	
	Properties p=new Properties();
	
	public BookingConfirmation makeAppointment() throws IOException {
		FileInputStream fs = new FileInputStream("D:\\Selenium Notes\\Selenium practice\\CuraHealthCare\\src\\main\\java\\curaTest\\resources\\GlobalData.properties");
        p.load(fs);
        String facility =p.getProperty("Facility");
        int date = Integer.parseInt(p.getProperty("date"))-1;
        int month=Integer.parseInt(p.getProperty("month"))-1;
       
		Select s = new Select(sel);
		s.selectByValue(facility);
		heprg.click();
		clkdtbox.click();
		clkmon.click();
		clkmon2.click();
		selDate.click();
		selMon.get(month).click();
		selday.get(date).click();
		cmt.sendKeys("Hello my first appointment");
		bokbtn.click();
		return new BookingConfirmation(driver);
	}

}
