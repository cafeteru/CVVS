package com.uniovi.pageObjects.posts;

import org.openqa.selenium.WebDriver;

import com.uniovi.pageObjects.POAbstract;
import com.uniovi.pageObjects.login.POLogin;
import com.uniovi.util.TestUtil;

public class POCreatePost extends POAbstract {

	public POCreatePost(WebDriver driver, TestUtil testUtil, String username,
			String password) {
		super(driver, testUtil);
		this.decorator = new POLogin(driver, testUtil, username, password);
	}

	@Override
	public void goToPage() {
		this.decorator.goToPage();
		testUtil.changeWebClick("posts");
		testUtil.changeWebClick("post-add");
	}
}
