package curaTest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CuraHealth.AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
}

	@FindBy(id="txt-username")
	WebElement usrname;
	
	@FindBy(id="txt-password")
	WebElement pass;
	
	@FindBy(id="btn-login")
	WebElement subBtn;
	
	@FindBy(css="p[class*='text-danger']")
	WebElement vryMsg;
	
	public BookAppointment goToAppointment() {
		usrname.sendKeys("John Doe");
		pass.sendKeys("ThisIsNotAPassword");
		subBtn.click();
		return new BookAppointment(driver);
	}
	
	public String InvalidLoginCred() {
		usrname.sendKeys("John");
		pass.sendKeys("ThisItAPassword");
		subBtn.click();
		waitForElementToAppear(vryMsg);
		return vryMsg.getText();
	}
}
