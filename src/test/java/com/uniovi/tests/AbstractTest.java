package com.uniovi.tests;

import com.uniovi.util.GetFilesInternet;
import com.uniovi.util.TestDriver;
import com.uniovi.util.TestUtil;
import org.openqa.selenium.WebDriver;

public abstract class AbstractTest {
	protected static WebDriver driver;
	protected static TestUtil testUtil;
	protected GetFilesInternet getFilesInternet;
	protected int secondsToWait;

	public AbstractTest() {
		driver = TestDriver.getDriver();
		testUtil = TestDriver.getTestUtil();
		this.secondsToWait = TestDriver.secondsToWait;
		this.getFilesInternet = new GetFilesInternet(testUtil);
	}
}
