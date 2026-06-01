package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseClass;
import utilities.ExtentReportManager;
import utilities.ScreenshotUtils;

public class TestListener implements ITestListener {
	
	public static Logger logger = LogManager.getLogger(TestListener.class);
	
	// ExtentReports instance — shared across all tests
    private static ExtentReports extent = ExtentReportManager.getInstance();

    // ExtentTest is per thread — important for parallel execution later
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	//Runs when a test starts
	@Override
	public void onTestStart(ITestResult result) {
		logger.info("====================================");
        logger.info("TEST STARTED: " + result.getName());
        logger.info("====================================");
        
        // Create a new test entry in report
        ExtentTest test = extent.createTest(result.getName());
        extentTest.set(test);
        extentTest.get().log(Status.INFO, "Test Started: " + result.getName());
	}
	
	//Runs when a test passes
	@Override
	public void onTestSuccess(ITestResult result) {
		 logger.info("✅ TEST PASSED: " + result.getName());
		 
		 extentTest.get().log(Status.PASS, "✅ Test Passed: " + result.getName());
	}
	
	//Runs when a test fails
	@Override
	public void onTestFailure(ITestResult result) {
		 logger.error("❌ TEST FAILED: " + result.getName());
		 logger.error("Reason: " + result.getThrowable());
		 
		 // Log failure reason in report
	        extentTest.get().log(Status.FAIL, "❌ Test Failed: " + result.getName());
	        extentTest.get().log(Status.FAIL, "Reason: " + result.getThrowable());

	     // Take screenshot and attach to report
	        String screenshotPath = ScreenshotUtils.captureScreenshot(BaseClass.getDriver(), result.getName());

	        try {
	            extentTest.get().fail(
	                "Screenshot on failure:",
	                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()
	            );
	        } catch (Exception e) {
	            logger.error("Could not attach screenshot to report: " + e.getMessage());
	        }
	}
	
	@Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("⚠️ TEST SKIPPED: " + result.getName());
        
        extentTest.get().log(Status.SKIP, "⚠️ Test Skipped: " + result.getName());
    }
	
	@Override
    public void onFinish(ITestContext context) {
        logger.info("====================================");
        logger.info("SUITE FINISHED");
        logger.info("Total Passed  : " + context.getPassedTests().size());
        logger.info("Total Failed  : " + context.getFailedTests().size());
        logger.info("Total Skipped : " + context.getSkippedTests().size());
        logger.info("====================================");
        
     // Flush writes everything to the HTML file
        extent.flush();
        logger.info("ExtentReport saved to /reports/AutomationReport.html");
    }
	

}
