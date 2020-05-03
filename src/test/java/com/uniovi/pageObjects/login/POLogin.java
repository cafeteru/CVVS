package com.uniovi.pageObjects.login;

import org.openqa.selenium.WebDriver;

import com.uniovi.pageObjects.POAbstract;
import com.uniovi.util.TestUtil;

public class POLogin extends POAbstract {

	public POLogin(WebDriver driver, TestUtil testUtil, int secondsToWait) {
		super(driver, testUtil, secondsToWait);
	}

	@Override
	public void goToPage() {
		testUtil.changeWebUrl("http://localhost:8090/login?lang=es");
		testUtil.waitSeconds(secondsToWait);
	}
}
