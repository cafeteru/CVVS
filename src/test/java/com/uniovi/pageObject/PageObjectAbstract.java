package com.uniovi.pageObject;

import org.openqa.selenium.WebDriver;

import com.uniovi.util.TestUtil;

public abstract class PageObjectAbstract {
	protected WebDriver driver;
	protected TestUtil testUtil;

	public PageObjectAbstract(WebDriver driver, TestUtil testUtil) {
		this.driver = driver;
		this.testUtil = testUtil;
	}

	public abstract void run();
}
