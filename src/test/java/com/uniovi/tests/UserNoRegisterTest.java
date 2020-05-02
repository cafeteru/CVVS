package com.uniovi.tests;

import org.junit.jupiter.api.Test;

import com.uniovi.pageObjects.login.POLogin;

public class UserNoRegisterTest extends AbstractTest {

	@Test
	void test() {
		String user = "noexist@gmail.com";
		new POLogin(driver, testUtil, user, "123456").goToPage();
		testUtil.textPresent(
				"Su correo electrónico y | o contraseña no son válidos", true);
		testUtil.textPresent("Esta es una zona privada la web", false);
		testUtil.textPresent(user, false);
		testUtil.textPresent("Publicaciones", false);
		testUtil.textPresent("Logout", false);
	}
}
