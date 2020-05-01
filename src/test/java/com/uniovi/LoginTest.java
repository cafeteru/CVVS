package com.uniovi;

import org.junit.jupiter.api.Test;

import com.uniovi.pageObject.PageObjectLoginUser;

public class LoginTest extends AbstractTest {
	@Test
	void loginOnSuccess() {
		PageObjectLoginUser login = new PageObjectLoginUser(driver, testUtil,
				"ivangonzalezmahagamage@gmail.com", "123456");
		login.run();
		testUtil.textPresent("Publicaciones", true);
		testUtil.textPresent("Logout", true);
	}
}
