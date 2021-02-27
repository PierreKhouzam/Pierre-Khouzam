package com.facebook.utilities.listeners;

import com.facebook.engine.BaseTest;
import com.facebook.utilities.constants.impConstants;
import com.facebook.utilities.extent.ExtentManager;
import com.facebook.utilities.extent.ExtentTestManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TestListener extends BaseTest implements ITestListener {


    public void onStart(ITestContext context) {
        System.out.println("*** Test Suite " + context.getName() + " started ***");
    }

    public void onTestStart(ITestResult result) {
        System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
    }


    public void onTestSkipped(ITestResult result) {
        System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
    }

    public void onFinish(ITestContext context) {
        System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
        File htmlFile = new File(impConstants.workingDir
                + "/extentreports/ExtentReportResults.html");
        try {
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            System.out.println("*** Couldn't fire report " + e);
        }
    }
}