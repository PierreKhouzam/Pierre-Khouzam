package com.facebook.pages;

import com.facebook.engine.BasePage;
import com.facebook.utilities.extent.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;

public class ForgottenPasswordPage extends BasePage {
    public ForgottenPasswordPage(WebDriver driver) {
        super(driver);
    }

    public ForgottenPasswordPage navigate() {
        try {
            waitVisibility("fgtPwdHeaderLbl");
            ExtentTestManager.getTest().log(LogStatus.PASS, "Standing on forgotten password page");
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Standing on forgotten password page");
        }
        return this;
    }

    public ForgottenPasswordPage backToLogin() {
        try {
            click("fgtPwdCancelBtn");
            waitVisibility("loginBtn");
            ExtentTestManager.getTest().log(LogStatus.PASS, "Cancel and back to login page");
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Cancel and back to login page");

        }
        return this;
    }
}
