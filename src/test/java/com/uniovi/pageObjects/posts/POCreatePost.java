package com.uniovi.pageobjects.posts;

import com.uniovi.pageobjects.POAbstract;
import com.uniovi.util.TestUtil;
import org.openqa.selenium.WebDriver;

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
