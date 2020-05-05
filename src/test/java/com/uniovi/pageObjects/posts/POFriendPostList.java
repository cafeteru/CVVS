package com.uniovi.pageObjects.posts;

import org.openqa.selenium.WebDriver;

import com.uniovi.pageObjects.POAbstract;
import com.uniovi.util.TestUtil;

public class POFriendPostList extends POAbstract {
	private final int idFriend;

	public POFriendPostList(WebDriver driver, TestUtil testUtil,
			int secondsToWait, int idFriend) {
		super(driver, testUtil, secondsToWait);
		this.idFriend = idFriend;
	}

	@Override
	public void goToPage() {
		testUtil.changeWebClick("" + idFriend);
		testUtil.waitSeconds(secondsToWait);
	}
}
