package pages;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utilities.ReadPropertiesFile;

public class PagesBaseClass {
	
	public WebDriver driver;
	public ExtentTest logger;
	public Properties prop ;
	

	public PagesBaseClass(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	
	/********************Open Application*************************/
	public LandingPage OpenApplication() {
		ReadPropertiesFile objProp = new ReadPropertiesFile();
		Properties prop = objProp.readPropertiesFile();
				
		driver.get(prop.getProperty("baseURL"));
		logger.log(Status.INFO, "Landed on MakeMyTrip Landing page.");
		LandingPage landingPage = new LandingPage(driver, logger);
		PageFactory.initElements(driver,landingPage);
		return landingPage;
	}
	
	
	/****************** Reporting Functions ***********************/
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
		//Assert.assertTrue(true);
		logger.log(Status.PASS, reportString);
	}

	


}
