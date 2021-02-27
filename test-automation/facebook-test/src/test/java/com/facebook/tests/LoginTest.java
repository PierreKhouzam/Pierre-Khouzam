package com.facebook.tests;


import com.facebook.actions.LoginAction;
import com.facebook.actions.LogoutAction;
import com.facebook.engine.BaseTest;
import com.facebook.utilities.extent.ExtentTestManager;
import com.facebook.utilities.listeners.TestListener;
import com.facebook.utilities.excel.ExcelUtils;
import com.facebook.utilities.constants.impConstants;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.facebook.engine.DriverScript.objectRepo;


@Listeners({TestListener.class})
public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public static void checkLoginLocalizationScenarios() {
        // set excel file loginTestData.xlsx
        ExcelUtils.setExcelFile(impConstants.pathTestData + "LoginTestData.xlsx");
        // Get row count of localization sheet
        int iTotalTestCases = ExcelUtils.getRowCount("Localization");
        for (int iTestcase = 1; iTestcase < iTotalTestCases; iTestcase++) {
            // Get testCaseName And testId from Localization Sheet
            String testCaseName = ExcelUtils.getCellData(iTestcase, impConstants.colTestCaseName, "Localization");
            String testId = ExcelUtils.getCellData(iTestcase, impConstants.colTestId, "Localization");
            // log TC to report
            ExtentTestManager.startTest(testId + ":" + testCaseName);
            // Get object and value from localization sheet
            String object = ExcelUtils.getCellData(iTestcase, impConstants.colObjectName, "Localization");
            String value = ExcelUtils.getCellData(iTestcase, impConstants.colObjectValue, "Localization");
            // Check login page localization with param object and value
            LoginAction.checkLocalization(object, value);
        }
    }

    @Test(priority = 2)
    public static void checkLoginValidationScenarios() {
        ExcelUtils.setExcelFile(impConstants.pathTestData + "LoginTestData.xlsx");
        int iTotalTestCases = ExcelUtils.getRowCount("Validation");
        for (int iTestcase = 1; iTestcase < iTotalTestCases; iTestcase++) {
            String testCaseName = ExcelUtils.getCellData(iTestcase, impConstants.colTestCaseName, "Validation");
            String testId = ExcelUtils.getCellData(iTestcase, impConstants.colTestId, "Validation");
            ExtentTestManager.startTest(testId + ": " + testCaseName);
            String username = ExcelUtils.getCellData(iTestcase, impConstants.colUsername, "Validation");
            String password = ExcelUtils.getCellData(iTestcase, impConstants.colPassword, "Validation");
            String firstResponseExpected = ExcelUtils.getCellData(iTestcase, impConstants.colFirstMessage, "Validation");
            String secondResponseExpected = ExcelUtils.getCellData(iTestcase, impConstants.colSecondMessage, "Validation");
            String altSecondResponseExpected = ExcelUtils.getCellData(iTestcase, impConstants.colAtSecondMessage, "Validation");
            String troubleResponseExpected = ExcelUtils.getCellData(iTestcase, impConstants.colTroubleMessage, "Validation");
            LoginAction.loginWithInvalidCredentials(username, password,
                    firstResponseExpected, secondResponseExpected,
                    altSecondResponseExpected, troubleResponseExpected);
        }
    }

    @Test(priority = 3)
    public static void checkLoginHappyScenarios() throws Exception {
        ExcelUtils.setExcelFile(impConstants.pathTestData + "LoginTestData.xlsx");
        int iTotalTestCases = ExcelUtils.getRowCount("Happy Scenarios");
        for (int iTestcase = 1; iTestcase < iTotalTestCases; iTestcase++) {
            String testCaseName = ExcelUtils.getCellData(iTestcase, impConstants.colTestCaseName, "Happy Scenarios");
            String testId = ExcelUtils.getCellData(iTestcase, impConstants.colTestId, "Happy Scenarios");
            ExtentTestManager.startTest(testId + ": " + testCaseName);
            String username = ExcelUtils.getCellData(iTestcase, impConstants.colUsername, "Happy Scenarios");
            String password = ExcelUtils.getCellData(iTestcase, impConstants.colPassword, "Happy Scenarios");
            LoginAction.loginWithValidCredentials(username, password);
            LogoutAction.execute();
        }
    }

    @Test(priority = 4)
    public static void checkUserCanShowHidePasswordOnToggle() throws Exception {
        ExcelUtils.setExcelFile(impConstants.pathTestData + "LoginTestData.xlsx");
        String testCaseName = ExcelUtils.getCellData(1, impConstants.colTestCaseName, "Standalone");
        String testId = ExcelUtils.getCellData(1, impConstants.colTestId, "Standalone");
        ExtentTestManager.startTest(testId + ":" + testCaseName);
        String password = ExcelUtils.getCellData(1, impConstants.colPassword, "Standalone");
        LoginAction.checkPassword(password);
    }

    @Test(priority = 5)
    public static void checkUserCanNavigateToForgottenPasswordPage() throws Exception {
        ExcelUtils.setExcelFile(impConstants.pathTestData + "LoginTestData.xlsx");
        String testCaseName = ExcelUtils.getCellData(2, impConstants.colTestCaseName, "Standalone");
        String testId = ExcelUtils.getCellData(2, impConstants.colTestId, "Standalone");
        ExtentTestManager.startTest(testId + ":" + testCaseName);
        LoginAction.checkNavigationToForgottenPassword();
    }

    @Test(priority = 6)
    public static void checkUserCanNavigateToCreateNewAccountPage() throws Exception {
        ExcelUtils.setExcelFile(impConstants.pathTestData + "LoginTestData.xlsx");
        String testCaseName = ExcelUtils.getCellData(3, impConstants.colTestCaseName, "Standalone");
        String testId = ExcelUtils.getCellData(3, impConstants.colTestId, "Standalone");
        ExtentTestManager.startTest(testId + ":" + testCaseName);
        LoginAction.checkNavigationToCreateNewAccount();
    }
}