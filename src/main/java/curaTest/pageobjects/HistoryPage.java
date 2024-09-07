package curaTest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CuraHealth.AbstractComponents.AbstractComponent;

public class HistoryPage extends AbstractComponent{

	WebDriver driver;
	public HistoryPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="facility")
	WebElement fac;
	
	public String verifyHistory() {
		return fac.getText();
	}
}
