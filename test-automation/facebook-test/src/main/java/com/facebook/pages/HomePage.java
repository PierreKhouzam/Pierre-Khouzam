package com.facebook.pages;

import com.facebook.engine.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openAccount() {
        click("accountTab");
        return this;
    }

    public HomePage clickLogout() {
        click("logoutBtn");
        return this;
    }

    public LoginPage toLoginPage() {
        waitVisibility("loginBtn");
        return new LoginPage(driver);
    }
}

