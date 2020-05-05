package com.uniovi;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.uniovi.util.TestDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * To run cucumber test.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "com.uniovi.tests", monochrome = true, plugin = {
		"pretty" })
public class CucumberTest {
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		driver = TestDriver.getDriver();
		driver.manage().window().maximize();
	}

	@AfterClass
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}