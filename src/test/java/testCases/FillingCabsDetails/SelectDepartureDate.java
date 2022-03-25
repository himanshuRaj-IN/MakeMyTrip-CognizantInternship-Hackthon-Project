package testCases.FillingCabsDetails;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;
import bsh.ParseException;

public class SelectDepartureDate extends BaseTestClass{
	
	@Test
	public void selectDepatureDate() throws java.text.ParseException, ParseException {
		logger = report.createTest("Select Departure Date ");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		cabsPage = landingPage.getCabsPage();
		cabsPage.clickOnDepartureDate();
		cabsPage.selectDepatureDate("30/04/2022");
		cabsPage.verifyDepatureDate("30/04/2022");
	}
	

	

}
