package com.uniovi.pageObjects.posts;

import org.openqa.selenium.WebDriver;

import com.uniovi.pageObjects.POAbstract;
import com.uniovi.util.TestUtil;

public class POCreatePost extends POAbstract {

	public POCreatePost(WebDriver driver, TestUtil testUtil,
			int secondsToWait) {
		super(driver, testUtil, secondsToWait);
	}

	@Override
	public void goToPage() {
		testUtil.changeWebClick("posts");
		testUtil.changeWebClick("post-add");
	}
}
