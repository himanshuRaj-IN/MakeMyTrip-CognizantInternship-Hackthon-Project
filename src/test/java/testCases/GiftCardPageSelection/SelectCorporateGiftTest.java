package testCases.GiftCardPageSelection;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;
import utilities.ReadPropertiesFile;

public class SelectCorporateGiftTest extends BaseTestClass {
	
	@Test
	public void SelectCorporateGiftTest() {
		logger = report.createTest("Navigate Corporate Gift Cards Page");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		String currWin = driver.getWindowHandle();
		giftCardsPage = landingPage.getGiftCardsPage();
		giftCardsPage.shiftDriverToCardsPage();
		giftCardsPage.verifyGiftCardsPageURL();
		giftCardsPage.clickOnCorporateGiftCard();
		driver.close();
		driver.switchTo().window(currWin);
	}
	

}
