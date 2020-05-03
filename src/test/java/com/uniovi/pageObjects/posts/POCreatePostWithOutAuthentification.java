package com.uniovi.pageobjects.posts;

import org.openqa.selenium.WebDriver;

import com.uniovi.pageobjects.POAbstract;
import com.uniovi.util.TestUtil;

public class POCreatePostWithOutAuthentification extends POAbstract {

	public POCreatePostWithOutAuthentification(WebDriver driver,
			TestUtil testUtil, int secondsToWait) {
		super(driver, testUtil, secondsToWait);
	}

	@Override
	public void goToPage() {
		testUtil.changeWebUrl("http://localhost:8090/post/add");
	}
}
