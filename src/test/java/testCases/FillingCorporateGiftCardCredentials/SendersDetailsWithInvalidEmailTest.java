package testCases.FillingCorporateGiftCardCredentials;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.Status;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class SendersDetailsWithInvalidEmailTest extends BaseTestClass {
	private static final Logger Logger = LogManager.getLogger(SendersDetailsWithInvalidEmailTest.class);
	@Test
	public void sendersDetailsWithInValidEmail() throws InterruptedException {
		logger = report.createTest("Senders Details With InValid Email");
		Logger.info("Checking Warning Message With InValid Email");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		String currWin = driver.getWindowHandle();
		giftCardsPage = landingPage.getGiftCardsPage();
		giftCardsPage.shiftDriverToCardsPage();
		giftCardsPage.verifyGiftCardsPageURL();
		giftCardsPage.clickOnCorporateGiftCard();

		giftCardsPage.enterSendersName("Pushkar Singh");
		giftCardsPage.enterMobileNo("7002041998");
		giftCardsPage.enterValidEmailId("xyzgmail.com");

		giftCardsPage.clickonBuyNowButton();
		String actualString = giftCardsPage.getEmailErrorMessage();
		Assert.assertEquals(actualString, "Please enter a valid Email id.");
		logger.log(Status.PASS, "Error Message : " + actualString);
		Logger.info("Error Message : " + actualString);
		driver.close();
		driver.switchTo().window(currWin);
	}
}
