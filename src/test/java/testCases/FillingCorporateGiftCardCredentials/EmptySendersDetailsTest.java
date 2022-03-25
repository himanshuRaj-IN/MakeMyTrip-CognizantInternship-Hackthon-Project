package testCases.FillingCorporateGiftCardCredentials;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class EmptySendersDetailsTest extends BaseTestClass {
	
	
	@Test
	public void EmptysendersdetailsTest() throws InterruptedException {
		logger = report.createTest(" Blank Senders Details Check");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		String currWin = driver.getWindowHandle();
		giftCardsPage = landingPage.getGiftCardsPage();
		giftCardsPage.shiftDriverToCardsPage();
		giftCardsPage.verifyGiftCardsPageURL();
		giftCardsPage.clickOnCorporateGiftCard();

		giftCardsPage.enterSendersName("");
		giftCardsPage.enterMobileNo("");
		giftCardsPage.enterValidEmailId("");

		giftCardsPage.clickonBuyNowButton();
		String actualString = giftCardsPage.emptyCredentialsErrorMessage();
		Assert.assertEquals(actualString, "This is a mandatory field");
		logger.log(Status.PASS, "Error Message : " + actualString);
		driver.close();
		driver.switchTo().window(currWin);
	}
	

}
