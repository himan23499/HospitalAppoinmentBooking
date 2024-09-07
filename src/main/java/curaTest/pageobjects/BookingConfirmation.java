package curaTest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CuraHealth.AbstractComponents.AbstractComponent;

public class BookingConfirmation extends AbstractComponent{

	WebDriver driver;
	public BookingConfirmation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css=".text-center p")
	WebElement confMsg;
	
	@FindBy(id="facility")
	WebElement facility;
	
	@FindBy(id="visit_date")
	WebElement date;
	public String verifyFacility() {
		return facility.getText();
	}
	public String verifyConfMsg() {
		return confMsg.getText();
	}
	public String verifyDate() {
		return date.getText();
	}

}
