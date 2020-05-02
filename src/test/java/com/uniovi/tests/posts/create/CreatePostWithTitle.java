package com.uniovi.tests.posts.create;

import org.junit.jupiter.api.Test;

import com.uniovi.pageObjects.posts.POCreatePost;
import com.uniovi.tests.AbstractTest;

public class CreatePostWithTitle extends AbstractTest {

	@Test
	void test() {
		String email = "cvvs@uniovi.es";
		String password = "123456";
		new POCreatePost(driver, testUtil, email, password).goToPage();
		testUtil.textPresent(
				"Su correo electrónico y | o contraseña no son válidos", false);
	}
}
