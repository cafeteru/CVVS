package com.uniovi.pageobjects.login;

import org.openqa.selenium.WebDriver;

import com.uniovi.pageobjects.POAbstract;
import com.uniovi.util.TestUtil;

public class POLoginIdentify extends POAbstract {
	private final String username;
	private final String password;

	public POLoginIdentify(WebDriver driver, TestUtil testUtil,
			int secondsToWait, String username, String password) {
		super(driver, testUtil, secondsToWait);
		this.decorator = new POLogin(driver, testUtil, secondsToWait);
		this.username = username;
		this.password = password;
	}

	@Override
	public void goToPage() {
		this.decorator.goToPage();
		testUtil.insertDataInput("username", username);
		testUtil.insertDataInput("password", password);
		testUtil.changeWebClick("login");
		testUtil.waitSeconds(secondsToWait);
	}
}
