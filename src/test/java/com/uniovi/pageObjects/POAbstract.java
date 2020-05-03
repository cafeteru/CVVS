package com.uniovi.pageobjects;

import org.openqa.selenium.WebDriver;

import com.uniovi.util.TestUtil;

public abstract class POAbstract implements PODecorator {
	protected WebDriver driver;
	protected TestUtil testUtil;
	protected int secondsToWait;

	protected PODecorator decorator;

	public POAbstract(WebDriver driver, TestUtil testUtil, int secondsToWait) {
		this.driver = driver;
		this.testUtil = testUtil;
		this.secondsToWait = secondsToWait;
	}
}
