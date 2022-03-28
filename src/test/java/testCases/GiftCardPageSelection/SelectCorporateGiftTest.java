package testCases.GiftCardPageSelection;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;

import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;
import testCases.FillingCorporateGiftCardCredentials.SendersDetailsWithoutNameTest;
import utilities.ReadPropertiesFile;

public class SelectCorporateGiftTest extends BaseTestClass {
	private static final Logger Logger = LogManager.getLogger(SelectCorporateGiftTest.class);
		
	@Test
	public void selectCorporateGiftTest() throws InterruptedException {
		logger = report.createTest("Navigate Corporate Gift Cards Page");
		Logger.info("Navigate Corporate Gift Cards Page Test initiated.");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		String currWin = driver.getWindowHandle();
		giftCardsPage = landingPage.getGiftCardsPage();
		giftCardsPage.shiftDriverToCardsPage();
		giftCardsPage.verifyGiftCardsPageURL();
		giftCardsPage.clickOnCorporateGiftCard();	
		Logger.info("Navigation to Corporate Gift Cards Page --> Successful ");
		driver.close();
		driver.switchTo().window(currWin);
		
	}
	

}
