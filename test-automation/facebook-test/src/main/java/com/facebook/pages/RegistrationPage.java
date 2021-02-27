package com.facebook.pages;

import com.facebook.engine.BasePage;
import com.facebook.utilities.extent.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage navigate() {
        try {
            waitVisibility("signupHeaderLbl");
            ExtentTestManager.getTest().log(LogStatus.PASS, "Standing on signup form");
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Standing on signup form");
        }
        return this;
    }

    public RegistrationPage backToLogin() {
        try {
            click("signupCancelBtn");
            waitVisibility("loginBtn");
            ExtentTestManager.getTest().log(LogStatus.PASS, "Cancel and back to login page");
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Cancel and back to login page");
        }
        return this;
    }
}