package BaseClasses;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.CabsPage;
import pages.GiftCardsPage;
import pages.HotelsPage;
import pages.LandingPage;
import pages.SearchPageCabs;
import utilities.DriverSetup;
import utilities.ExtentReportManager;

public class BaseTestClass {
	public  static org.openqa.selenium.WebDriver driver;
	public  static ExtentTest logger;
	public  static ExtentReports report;
	
	public static LandingPage landingPage;
	public static CabsPage cabsPage;
	public static HotelsPage hotelsPage;
	public static GiftCardsPage giftCardsPage;
	public static SearchPageCabs searchPageCabs;
	
	@BeforeSuite(alwaysRun = true)
	public void setup() {
		invokeBrowser();
		report = ExtentReportManager.getReportInstance();
	}
	
	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		driver.quit();
		report.flush();
	}
	
	@AfterMethod
	public void setTestResult(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			logger.fail(result.getName());
			logger.fail(result.getThrowable());
		}else if(result.getStatus() == ITestResult.SUCCESS) {
			logger.pass(result.getName());
		}else if(result.getStatus() == ITestResult.SKIP) {
			logger.skip(result.getName());
		}
	}
	
	public void invokeBrowser() {
		DriverSetup driverSetupObjDriverSetup = new DriverSetup();
		driver = driverSetupObjDriverSetup.driverSetup(driver);
	}
}