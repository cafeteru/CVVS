package com.uniovi.pageObjects.friends;

import org.openqa.selenium.WebDriver;

import com.uniovi.pageObjects.POAbstract;
import com.uniovi.util.TestUtil;

public class POFriendList extends POAbstract {

	public POFriendList(WebDriver driver, TestUtil testUtil,
			int secondsToWait) {
		super(driver, testUtil, secondsToWait);
	}

	@Override
	public void goToPage() {
		testUtil.changeWebClick("friends");
		testUtil.waitSeconds(secondsToWait);
	}
}
