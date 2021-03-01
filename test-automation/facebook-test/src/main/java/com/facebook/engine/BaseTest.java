package com.facebook.engine;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;

    @BeforeClass
    public void setup() {
        // setup chrome driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        // maximize window
        driver.manage().window().maximize();
        // load object repository
        DriverScript.objectRepoLoad();
    }

    @BeforeMethod
    public void openBaseURL() {
        // open base URL
        driver.get("https://www.facebook.com/");
    }


    @AfterClass
    public void teardown() {
        // quitting web driver
        driver.quit();
    }

}
