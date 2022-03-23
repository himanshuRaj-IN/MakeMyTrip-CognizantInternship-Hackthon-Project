package testCases.FillingCabsDetails;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import bsh.ParseException;
import pages.PagesBaseClass;

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
		
		
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/***************** Select Date From Calendar 
	 * @throws java.text.ParseException *****************/
	public void selectDateIncalendar(String date) throws java.text.ParseException, ParseException {

		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date expectedDate = dateFormat.parse(date);

		String day = new SimpleDateFormat("dd").format(expectedDate);
		String month = new SimpleDateFormat("MMMM").format(expectedDate);
		String year = new SimpleDateFormat("yyyy").format(expectedDate);

		String expectedMonthYear = month + " " + year;

		while (true) {
			String displayDate = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]")).getText();
			System.out.println(displayDate);
			if (expectedMonthYear.equals(displayDate)) {

				driver.findElement(By.xpath("(//div[contains(text(),'"+day+"')])[1]")).click();

				break;
			} else if (expectedDate.compareTo(currentDate) > 0) {
				driver.findElement(By.xpath("(//span[@role = 'button'])[2]")).click();
			} else {
				driver.findElement(By.xpath("(//span[@role = 'button'])[1]")).click();
			}

		}

	}

}
