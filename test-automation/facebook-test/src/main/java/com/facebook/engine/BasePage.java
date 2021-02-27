package com.facebook.engine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import static com.facebook.engine.DriverScript.objectRepo;


public class BasePage {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static SoftAssert softAssert = new SoftAssert();

    // Constructor
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    // wait method
    public void waitVisibility(String object) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectRepo.getProperty(object))));
    }

    // click method
    public void click(String object) {
        waitVisibility(object);
        driver.findElement(By.xpath(objectRepo.getProperty(object))).click();
    }

    // write text method
    public void writeText(String object, String data) {
        waitVisibility(object);
        driver.findElement(By.xpath(objectRepo.getProperty(object))).clear();
        driver.findElement(By.xpath(objectRepo.getProperty(object))).sendKeys(data);
    }

    // read text method
    public String readText(String object) {
        waitVisibility(object);
        return driver.findElement(By.xpath(objectRepo.getProperty(object))).getText();
    }

    // get element attribute
    public String getElementAttribute(String object, String attribute) {
        waitVisibility(object);
        return driver.findElement(By.xpath(objectRepo.getProperty(object))).getAttribute(attribute);
    }

    // check element is displayed
    public Boolean isDisplayed(String object) {
        return driver.findElement(By.xpath(objectRepo.getProperty(object))).isDisplayed();
    }

}
