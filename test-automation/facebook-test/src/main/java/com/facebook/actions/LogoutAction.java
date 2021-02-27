package com.facebook.actions;

import com.facebook.engine.BaseTest;
import com.facebook.pages.HomePage;

public class LogoutAction extends BaseTest {

    public static void execute() throws Exception {
        HomePage homepage = new HomePage(driver);
        homepage.openAccount().clickLogout().toLoginPage();
    }
}
