package com.uniovi.tests.posts;

import org.junit.jupiter.api.Test;

import com.uniovi.pageObjects.login.POLogin;
import com.uniovi.tests.AbstractTest;

public class UserNoRegisterTest extends AbstractTest {

	@Test
	void test() {
		String user = "noexist@gmail.com";
		String password = "123456";
		new POLogin(driver, testUtil, user, password).goToPage();
		testUtil.textPresent(
				"Su correo electrónico y | o contraseña no son válidos", true);
		testUtil.textPresent("Esta es una zona privada la web", false);
		testUtil.textPresent(user, false);
		testUtil.textPresent("Publicaciones", false);
		testUtil.textPresent("Logout", false);
	}
}
