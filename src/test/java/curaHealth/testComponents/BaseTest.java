package curaHealth.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import curaTest.pageobjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage ld;
	public WebDriver initializeDriver() throws IOException {
	
	Properties prop =new Properties();
	FileInputStream fs = new FileInputStream("D:\\Selenium Notes\\Selenium practice\\CuraHealthCare\\src\\main\\java\\curaTest\\resources\\GlobalData.properties");
	prop.load(fs);
	String browserName = System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
	if(browserName.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	}else if(browserName.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
	}else {
		driver = new EdgeDriver();
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	return driver;
	}
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
//		TakesScreenshot ts = (TakesScreenshot)driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File destination =new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
//		FileUtils.copyFile(source, destination);
//		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target =new File( System.getProperty("user.dir") + "//reports//" + testCaseName+".png");
		FileUtils.copyFile(source, target);
		return System.getProperty("user.dir") + "//reports//" + testCaseName+".png";
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		 ld=new LandingPage(driver);
		ld.goTo();
		return ld;
	}
	public void tearDown() {
		driver.close();
	}
}
