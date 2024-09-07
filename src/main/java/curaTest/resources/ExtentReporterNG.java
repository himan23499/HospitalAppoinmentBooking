package curaTest.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);//Ui of the report
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Automation Test Results");
		
		ExtentReports ex = new ExtentReports();
		ex.attachReporter(reporter);
		ex.setSystemInfo("Tester", "Himanshu");
		return ex;
	}
}
