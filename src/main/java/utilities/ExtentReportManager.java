package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	
	public static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		
		if (extent == null) {

            // Path where HTML report will be saved
            String reportPath = System.getProperty("user.dir") 
                              + "/reports/AutomationReport.html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

            // Report configuration
            sparkReporter.config().setReportName("OpenCart Automation Report");
            sparkReporter.config().setDocumentTitle("Test Execution Report");
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setEncoding("utf-8");
            
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            // System info shown in report
            extent.setSystemInfo("Project", "OpenCart Automation");
            extent.setSystemInfo("Tester", "Satya Sai Krishna");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("OS", System.getProperty("os.name"));

        }

        return extent;
	}
	

}
