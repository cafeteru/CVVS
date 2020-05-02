package com.uniovi.pageObjects;

import org.openqa.selenium.WebDriver;

import com.uniovi.util.TestUtil;

public abstract class POAbstract implements PODecorator {
	protected WebDriver driver;
	protected TestUtil testUtil;

	protected PODecorator decorator;

	public POAbstract(WebDriver driver, TestUtil testUtil) {
		this.driver = driver;
		this.testUtil = testUtil;
	}
}
