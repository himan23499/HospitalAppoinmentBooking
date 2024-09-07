package curaTest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CuraHealth.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="menu-toggle")
	WebElement menu;
	
	@FindBy(xpath="//ul[@class='sidebar-nav']/li[3]")
	WebElement loginlnk;
	
	@FindBy(xpath="//ul[@class='sidebar-nav']/li[3]")
	WebElement historylnk;
	
	public LoginPage goToLogin() {
		menu.click();
		waitForElementToAppear(loginlnk);
		loginlnk.click();
		return new LoginPage(driver);
	}
	
	public HistoryPage goToHistory() {
		
		menu.click();
		waitForElementToAppear(historylnk);
		historylnk.click();
		return new HistoryPage(driver);
	}
	
	public void goTo() {
		driver.get("https://katalon-demo-cura.herokuapp.com/");
	}

}
