package com.uniovi.pageObject;

import org.openqa.selenium.WebDriver;

import com.uniovi.util.TestUtil;

public class PageObjectLoginUser extends PageObjectAbstract {
	private String username;
	private String password;

	public PageObjectLoginUser(WebDriver driver, TestUtil testUtil,
			String username, String password) {
		super(driver, testUtil);
		this.username = username;
		this.password = password;
	}

	@Override
	public void run() {
		testUtil.changeWebUrl("http://localhost:8090/login");
		testUtil.insertDataInput("username", username);
		testUtil.insertDataInput("password", password);
		testUtil.changeWebClick("login");
		testUtil.waitSeconds(5);
	}
}
