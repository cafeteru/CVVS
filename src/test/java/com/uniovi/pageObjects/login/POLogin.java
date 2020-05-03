package com.uniovi.pageobjects.login;

import org.openqa.selenium.WebDriver;

import com.uniovi.pageobjects.POAbstract;
import com.uniovi.util.TestUtil;

public class POLogin extends POAbstract {

	public POLogin(WebDriver driver, TestUtil testUtil, int secondsToWait) {
		super(driver, testUtil, secondsToWait);
	}

	@Override
	public void goToPage() {
		testUtil.changeWebUrl("http://localhost:8090/login?lang=en");
		testUtil.waitSeconds(secondsToWait);
	}
}
