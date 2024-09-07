package curaHealth.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import curaHealth.testComponents.BaseTest;
import curaTest.Utilities.ReadConfig;
import curaTest.pageobjects.BookAppointment;
import curaTest.pageobjects.BookingConfirmation;
import curaTest.pageobjects.HistoryPage;
import curaTest.pageobjects.LoginPage;


public class EtETest extends BaseTest {
	
	BookAppointment ap;
	ReadConfig r;
	@Test
	public void TC_01_LoginPositiveCase() {
		LoginPage lg=	ld.goToLogin();
		 ap =lg.goToAppointment();
		 
	}
	 
	@Test
	public void TC_02_LoginNegativeCase() {
		LoginPage lg=	ld.goToLogin();
		String msg = lg.InvalidLoginCred();
		Assert.assertEquals(msg,"Login failed! Please ensure the username and password are valid.");
	}
	
	@Test
	public void TC_03_BookAppointment() throws IOException {

        int date = Integer.parseInt("23")-1;
        int month=Integer.parseInt("06")-1;
		LoginPage lg=	ld.goToLogin();
		
		 ap =lg.goToAppointment();
		 BookingConfirmation bc= ap.makeAppointment();
		 Assert.assertEquals("Please be informed that your appointment has been booked as following:",bc.verifyConfMsg());
		 Assert.assertEquals("Tokyo CURA Healthcare Center",bc.verifyFacility());
		 String ActualDate = bc.verifyDate().split("/")[0];
		 String ActualMonth = bc.verifyDate().split("/")[1];
		 if(Integer.parseInt(ActualMonth)<10) {
			 ActualMonth.replace("0","");
		 }
		 Assert.assertEquals(date+1,Integer.parseInt(ActualDate));
		 Assert.assertEquals(month+1,Integer.parseInt(ActualMonth));
	}
	
	@Test
	public void TC_04_VerifyIfBookingIsAddedToHistoryPage() throws IOException {
		LoginPage lg=	ld.goToLogin();
		 ap =lg.goToAppointment();
		 BookingConfirmation bc= ap.makeAppointment();
		HistoryPage hs = ld.goToHistory();
		Assert.assertEquals("Tokyo CURA Healthcare Center", hs.verifyHistory());
	
		
	}
	
}
