package testCases.FillingCorporateGiftCardCredentials;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class SendersDetailsWithInvalidMobileNum extends BaseTestClass {

	
	@Test
	public void sendersDetailsWithInValidMobileNumber() throws InterruptedException {
		logger = report.createTest("Senders Details With InValid Mobile Number");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		String currWin = driver.getWindowHandle();
		giftCardsPage = landingPage.getGiftCardsPage();
		giftCardsPage.shiftDriverToCardsPage();
		giftCardsPage.verifyGiftCardsPageURL();
		giftCardsPage.clickOnCorporateGiftCard();

		giftCardsPage.enterSendersName("Pushkar Singh");
		giftCardsPage.enterMobileNo("700204199899999");
		giftCardsPage.enterValidEmailId("xyz@gmail.com");

		giftCardsPage.clickonBuyNowButton();
		String actualString = giftCardsPage.getMobileNumberErrorMessage();
		Assert.assertEquals(actualString, "Please enter a valid mobile number");
		logger.log(Status.PASS, "Error Message : " + actualString);
		
		driver.close();
		driver.switchTo().window(currWin);
	}
}
