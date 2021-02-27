package com.facebook.utilities.extent;

import com.facebook.utilities.constants.impConstants;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            // set HTML report file location
            extent = new ExtentReports(impConstants.workingDir
                    + "/extentreports/ExtentReportResults.html", true);
        }
        return extent;
    }
}