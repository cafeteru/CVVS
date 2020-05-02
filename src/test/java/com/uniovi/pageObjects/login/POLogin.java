package com.uniovi.pageObjects.login;

import org.openqa.selenium.WebDriver;

import com.uniovi.pageObjects.POAbstract;
import com.uniovi.util.TestUtil;

public class POLogin extends POAbstract {
	private String username;
	private String password;

	public POLogin(WebDriver driver, TestUtil testUtil, String username,
			String password) {
		super(driver, testUtil);
		this.username = username;
		this.password = password;
	}

	@Override
	public void goToPage() {
		testUtil.changeWebUrl("http://localhost:8090/login?lang=es");
		testUtil.insertDataInput("username", username);
		testUtil.insertDataInput("password", password);
		testUtil.changeWebClick("login");
		testUtil.waitSeconds(5);

	}
}
