package pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PagesBaseClass;
import utilities.ReadPropertiesFile;

public class HotelsPage extends PagesBaseClass{
	Properties prop;
	public HotelsPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		ReadPropertiesFile objProp = new ReadPropertiesFile();
		prop = objProp.readPropertiesFile();
	}
	
	
	public void verifyHotelsPageURL() {
		try {
			String ExpectedURL= prop.getProperty("hotelsPageURL");
			String ActualURL=driver.getCurrentUrl();
			if (ActualURL.equals(ExpectedURL)) {
				reportPass("PASS : URL Verified [ Got ->" + ActualURL+" ]");
			}else {
				reportFail("FAIL : URL Not Verified [ Got ->" + ExpectedURL+" ]");
			}
		} catch (Exception e) {
				reportFail("Exception Occured -> "+e.getMessage());
		}
	}
	
	public void forceFailed() {
		logger.log(Status.INFO, "Main fail hojaiga");
	

		Assert.assertEquals(true,true );
		logger.log(Status.PASS,"1 assert");
		Assert.assertEquals(true,true);
		logger.log(Status.PASS, "2nd assert");
		Assert.assertEquals(true,true );
		logger.log(Status.PASS,"3 assert");
		try{ 
		Assert.assertEquals(true, false);
		logger.log(Status.PASS, "4 assert");}
		catch (AssertionError e) {
			logger.log(Status.FAIL, "4 assert");
		}
		
	
}


}