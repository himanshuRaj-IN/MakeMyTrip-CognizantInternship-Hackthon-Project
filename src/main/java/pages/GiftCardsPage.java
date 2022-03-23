package pages;

import java.awt.Window;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ReadPropertiesFile;

public class GiftCardsPage extends PagesBaseClass{
	Properties prop;
	public GiftCardsPage(WebDriver ldriver,ExtentTest logger) {
		super(ldriver, logger);
		ReadPropertiesFile objProp = new ReadPropertiesFile();
		prop = objProp.readPropertiesFile();
		
	}
	
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/ul[1]/li[3]/div[1]/img[1]")
	WebElement CorporateGiftCardpara_Element;
	
	public void shiftDriverToCardsPage() {
		try {
		logger.log(Status.INFO, "Shifting driver focus to the Gift cards page ");
		for(String winHandle : driver.getWindowHandles()){
			   driver.switchTo().window(winHandle);
			   
			}
		}catch (Exception e) {
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

	/******************** Select corporate Gift Card******************************/
	public void clickOnCorporateGiftCard() {
		try {
	
			CorporateGiftCardpara_Element.click();
			logger.log(Status.PASS, "Clicked on corporate Gift Card");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}
}
