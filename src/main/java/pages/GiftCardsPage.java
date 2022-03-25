package pages;

import java.awt.Window;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PagesBaseClass;
import utilities.ReadPropertiesFile;

public class GiftCardsPage extends PagesBaseClass {
	Properties prop;

	public GiftCardsPage(WebDriver ldriver, ExtentTest logger) {
		super(ldriver, logger);
		ReadPropertiesFile objProp = new ReadPropertiesFile();
		prop = objProp.readPropertiesFile();

	}

	@FindBy(xpath = "//p[contains(text(),'Corporate Gift Card')]")
	WebElement CorporateGiftCard_Element;

	@FindBy(xpath = "//input[@name=\"senderName\"]")
	WebElement SendersName_Element;

	@FindBy(xpath = "//input[@name=\"senderMobileNo\"]")
	WebElement SendersMobileNum_Element;

	@FindBy(xpath = "//input[@name=\"senderEmailId\"]")
	WebElement sendersEmailiD_Element;

	@FindBy(xpath = "//button")
	WebElement buyNowButton_Element;
	
	@FindBy(xpath = "//span[text()='Payment options']")
	WebElement paymentOptionLabel_Element;

	public void shiftDriverToCardsPage() {
		try {
			logger.log(Status.INFO, "Shifting driver focus to the Gift cards page ");
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);

			}
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public void verifyGiftCardsPageURL() {
		try {
			String ExpectedURL = prop.getProperty("giftCardPageURL");
			String ActualURL = driver.getCurrentUrl();
			Assert.assertEquals(ActualURL, ExpectedURL);
			logger.log(Status.PASS, "PASS : URL Verified [ Got -> " + ActualURL + " ]");

		} catch (Exception e) {
			reportFail("Exception Occured -> " + e.getMessage());
		}
	}

	/******************** Select corporate Gift Card ******************************/
	public void clickOnCorporateGiftCard() {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", CorporateGiftCard_Element);
			logger.log(Status.PASS, "Clicked on corporate Gift Card");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	/******** Enter Senders Name in corporate gift card ************/
	public void enterSendersName() {
		try {

			SendersName_Element.sendKeys("Pushkar");

			logger.log(Status.PASS, "Entered the Senders Name");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/*********** Enter Mobile No in Corporate Gift Card **********/
	public void enterMobileNo() {
		try {

			SendersMobileNum_Element.sendKeys("8271987994");
			logger.log(Status.PASS, "Entered the Mobile No");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/******** Enter Valid Email Id in Corporate Gift Card ********/
	public void enterValidEmailId() {
		try {

			sendersEmailiD_Element.sendKeys("singhpushkar108@gmail.com");

			logger.log(Status.PASS, "Entered the Valid Email ID");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/******* Click on Buy Now Button *******************/
	public void clickonBuyNowButton() {
		try {

			buyNowButton_Element.click();
			logger.log(Status.PASS, "Clicked on Buy Now Button");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	/*************** Verify payment page *******************/
	public boolean isRedirectedToPaymentPage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(paymentOptionLabel_Element));
			String str = paymentOptionLabel_Element.getText();
			if(str.equals("Payment options")) {
				logger.log(Status.PASS, "Redirected to the payment page.");
				return true;
			}else {
				logger.log(Status.INFO, "Redirected to the payment page Failled .");
				return false;
			}
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		return false;
	}

}
