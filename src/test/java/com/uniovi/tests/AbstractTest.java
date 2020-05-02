package com.uniovi.tests;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.uniovi.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractTest {
	protected static WebDriver driver;
	protected static TestUtil testUtil;
	protected static Map<String, String> variables;

	@BeforeAll
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		testUtil = new TestUtil(driver);
		variables = new HashMap<>();
		driver.manage().window().maximize();
	}

	@BeforeEach
	void initTest() {

	}

	@AfterEach
	void finishTest() {
		driver.manage().deleteAllCookies();
	}

	@AfterAll
	public static void finishAllTest() {
		if (driver != null) {
			driver.quit();
		}
	}
}
