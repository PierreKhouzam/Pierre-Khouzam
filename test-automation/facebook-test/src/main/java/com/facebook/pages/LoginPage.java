package com.facebook.pages;

import com.facebook.engine.BasePage;
import com.facebook.utilities.extent.ExtentTestManager;
import com.facebook.utilities.screenshots.ScreenshotRobot;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(String username) {
        try {
            writeText("emailInput", username);
            ExtentTestManager.getTest().log(LogStatus.PASS, "Enter username: '" + username + "' ");
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Enter username: '" + username + "' ");
        }
        return this;
    }

    public LoginPage enterPassword(String password) {
        try {
            writeText("passwordInput", password);
            ExtentTestManager.getTest().log(LogStatus.PASS, " Enter password: '" + password + "' ");
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, " Enter password: '" + password + "' ");
        }
        return this;
    }

    public LoginPage clickLogin() {
        try {
            click("loginBtn");
            ExtentTestManager.getTest().log(LogStatus.PASS, "Click login");
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Click login");
        }
        return this;
    }

    public HomePage toHomePage() {
        try {
            waitVisibility("homeTab");
            ExtentTestManager.getTest().log(LogStatus.PASS, "Redirect to homepage");
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Redirect to homepage");
        }
        return new HomePage(driver);
    }

    //TODO  handle more dynamic failed Facebook login responses
    public void validate(String firstExpectedResponse, String secondExpectedResponse, String altSecondExpectedResponse, String troubleExpectedResponse) {
        String validationText;
        if (isDisplayed("validationText1")) {
            validationText = readText("validationText1");
            try {
                softAssert.assertTrue(validationText.contains(firstExpectedResponse));
                ExtentTestManager.getTest().log(LogStatus.PASS, "Actual text matches the expected text");
            } catch (Exception e) {
                ExtentTestManager.getTest().log(LogStatus.FAIL,
                        "Actual text is '" + validationText + "' while expected text should be '" + firstExpectedResponse + "'");
            }
        } else if (isDisplayed("validationText2")) {
            validationText = readText("validationText2");
            try {
                softAssert.assertTrue(validationText.contains(secondExpectedResponse) || validationText.contains(altSecondExpectedResponse));
                ExtentTestManager.getTest().log(LogStatus.PASS, "Actual text matches the expected text");
            } catch (Exception e) {
                ExtentTestManager.getTest().log(LogStatus.FAIL,
                        "Actual text is '" + validationText + "' while expected text should be '" + secondExpectedResponse + "' or '" + altSecondExpectedResponse);
            }
        } else if (isDisplayed("troubleValidationText")) {
            validationText = readText("troubleValidationText");
            try {
                softAssert.assertTrue(validationText.contains(troubleExpectedResponse));
                ExtentTestManager.getTest().log(LogStatus.PASS, "Redirect to trouble logging in page where actual text matches the expected text");
                ScreenshotRobot.takeScreenShot(driver);
            } catch (Exception e) {
                ExtentTestManager.getTest().log(LogStatus.FAIL,
                        "Actual text is '" + validationText + "' while expected text should be '" + troubleExpectedResponse + "'");
                ScreenshotRobot.takeScreenShot(driver);
            }
            click("tryAgainBtn");
            ExtentTestManager.getTest().log(LogStatus.PASS, "Click on try again");
        }
    }


    public void localize(String object, String expectedText) {
        String actualText = readText(object);
        String altActualText = getElementAttribute(object, "placeholder");
        try {
            softAssert.assertTrue(actualText.equals(expectedText) || altActualText.equals(expectedText));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Actual text matches the expected text: " + expectedText);
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.FAIL,
                    "Actual text is '" + actualText + "' while expected text should be '" + expectedText + "'");
        }
    }

    public LoginPage showPassword() {
        try {
            click("showPasswordToggle");
            String visiblePassword = readText("passwordInput");
            softAssert.assertTrue(visiblePassword.contains("123"));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Password is visible");
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Password is visible");
        }
        return this;
    }

    public LoginPage hidePassword() {
        try {
            click("hidePasswordToggle");
            String hiddenPassword = readText("passwordInput");
            softAssert.assertTrue(hiddenPassword.contains("•••"));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Password is hidden");
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Password is hidden");
        }
        return this;
    }

    public ForgottenPasswordPage clickForgottenPassword() {
        try {
            click("forgetPasswordLink");
            ExtentTestManager.getTest().log(LogStatus.PASS, "Click forgotten password link");
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Click forgotten password link");
        }
        return new ForgottenPasswordPage(driver);
    }

    public RegistrationPage clickCreateNewAccount() {
        try {
            click("createAccountBtn");
            ExtentTestManager.getTest().log(LogStatus.PASS, "Click create new account button");
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Click create new account button");
        }
        return new RegistrationPage(driver);
    }
}