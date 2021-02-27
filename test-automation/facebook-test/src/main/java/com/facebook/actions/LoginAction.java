package com.facebook.actions;

import com.facebook.engine.BaseTest;
import com.facebook.pages.LoginPage;
import com.facebook.utilities.screenshots.ScreenshotRobot;

public class LoginAction extends BaseTest {

    public static void loginWithValidCredentials(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username).enterPassword(password).clickLogin().toHomePage();
        ScreenshotRobot.takeScreenShot(driver);
    }

    public static void loginWithInvalidCredentials(String username, String password,
                                                   String firstResponseExpected, String secondResponseExpected,
                                                   String altSecondResponseExpected, String troubleResponseExpected) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username).enterPassword(password).clickLogin()
                .validate(firstResponseExpected, secondResponseExpected, altSecondResponseExpected, troubleResponseExpected);
        ScreenshotRobot.takeScreenShot(driver);
    }

    public static void checkLocalization(String object, String value) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.localize(object, value);
        ScreenshotRobot.takeScreenShot(driver);
    }

    public static void checkPassword(String password) throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword(password).showPassword();
        ScreenshotRobot.takeScreenShot(driver);
        loginPage.hidePassword();
        ScreenshotRobot.takeScreenShot(driver);
    }

    public static void checkNavigationToForgottenPassword() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgottenPassword().navigate();
        ScreenshotRobot.takeScreenShot(driver);
    }

    public static void checkNavigationToCreateNewAccount() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickCreateNewAccount().navigate();
        ScreenshotRobot.takeScreenShot(driver);
    }
}

