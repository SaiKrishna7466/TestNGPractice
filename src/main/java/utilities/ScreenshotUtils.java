package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	
	private static Logger logger = LogManager.getLogger(ScreenshotUtils.class);
	
	/**
     * Captures screenshot and saves to /screenshots folder
     * @param driver   - WebDriver instance
     * @param testName - Name of the test (used in filename)
     * @return full path of saved screenshot
     */

	public static String captureScreenshot(WebDriver driver, String testName) {
		
		String screenshotPath = "";
		
		try {
			//unique timestamp for filename
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String screenshotName = testName + "_" + timeStamp + ".png";
			
			//Take Screenshot
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			
			// Save to /screenshots folder in project root
			screenshotPath = System.getProperty("user.dir")+ File.separator + "screenshots"+ File.separator + screenshotName;
			File dest = new File(screenshotPath);
			
			// Create screenshots folder if it doesn't exist
			dest.getParentFile().mkdirs();
			
			FileUtils.copyFile(src, dest);
			
			 logger.info("Screenshot saved at: " + screenshotPath);
		}catch(IOException e) {
			logger.error("Screenshot capture failed: " + e.getMessage());
		}
		
		return screenshotPath;
		
	}

}
