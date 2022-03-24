package BaseClasses;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.CabsPage;
import pages.GiftCardsPage;
import pages.HotelsPage;
import pages.LandingPage;
import pages.SearchPageCabs;
import utilities.CaptureScreenshot;
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
	public void setTestResult(ITestResult result) throws IOException {
		
		String	screenshot = CaptureScreenshot.captureScreenShot(driver, CaptureScreenshot.generateFileName(result));
		
		if(result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL,result.getName()+"  : FAILLED");
			logger.log(Status.FAIL,result.getThrowable());
			
			logger.fail("Screenshot : "+ logger.addScreenCaptureFromPath(screenshot));
		}else if(result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, result.getName() + "  : PASSED");
			logger.pass("Screenshot : "+ logger.addScreenCaptureFromPath(screenshot));
		}else if(result.getStatus() == ITestResult.SKIP) {
			logger.skip(result.getName());
		}
	}
	
	public void invokeBrowser() {
		DriverSetup driverSetupObjDriverSetup = new DriverSetup();
		driver = driverSetupObjDriverSetup.driverSetup(driver);
	}
}