package com.facebook.utilities.screenshots;

import com.facebook.utilities.extent.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ScreenshotRobot {

    public static void takeScreenShot(WebDriver driver) {
        try {
            // take base64Screenshot screenshot for extent reports
            String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).
                    getScreenshotAs(OutputType.BASE64);
            // extent reports log and screenshot operations for test steps
            ExtentTestManager.getTest().log(LogStatus.INFO, "Test Step",
                    ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
        } catch (Exception e) {
            System.out.println("Failed to take screenshot " + e.getMessage());
        }
    }
}