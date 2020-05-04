package com.uniovi.pageObjects.posts;

import org.openqa.selenium.WebDriver;

import com.uniovi.pageObjects.POAbstract;
import com.uniovi.util.TestUtil;

public class POViewPostWithOutAuthentification extends POAbstract {

	public POViewPostWithOutAuthentification(WebDriver driver,
			TestUtil testUtil, int secondsToWait) {
		super(driver, testUtil, secondsToWait);
	}

	@Override
	public void goToPage() {
		testUtil.changeWebUrl("http://localhost:8090/post/add");
	}
}