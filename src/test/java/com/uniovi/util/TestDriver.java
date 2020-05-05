package com.uniovi.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDriver {
    public static WebDriver driver;
    public static TestUtil testUtil;
    public static int secondsToWait = 3;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static TestUtil getTestUtil() {
        if (testUtil == null) {
            testUtil = new TestUtil(getDriver());
        }
        return testUtil;
    }
}
