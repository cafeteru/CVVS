package com.uniovi.tests.posts.create;

import java.util.Date;

import com.uniovi.pageobjects.login.POLoginIdentify;
import com.uniovi.pageobjects.posts.POCreatePost;
import com.uniovi.tests.AbstractTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreatePostWithTitleTest extends AbstractTest {
	private final int secondsToWait = 5;
	private final String title = "Titulo de la publicación "
			+ new Date().toString();

	@Given("The user is identified")
	public void the_user_is_identified() {
		String email = "cvvs@uniovi.es";
		String password = "123456";
		new POLoginIdentify(driver, testUtil, secondsToWait, email, password)
				.goToPage();
		testUtil.textPresent(
				"Su correo electrónico y | o contraseña no son válidos", false);
		testUtil.textPresent("Registrarse", false);
		testUtil.textPresent("Logout", true);
	}

	@When("tries to access the post creation menu")
	public void tries_to_access_the_post_creation_menu() {
		new POCreatePost(driver, testUtil, secondsToWait).goToPage();
		testUtil.textPresent(
				"Su correo electrónico y | o contraseña no son válidos", false);
		testUtil.textPresent("Añadir publicación", true);
	}

	@When("just enter the title")
	public void just_enter_the_title() {
		testUtil.insertDataInput("title", title);
	}

	@Then("the application does not create the post")
	public void the_application_does_not_create_the_post() {
		testUtil.changeWebClick("add");
		testUtil.waitSeconds(secondsToWait);
		testUtil.textPresent("Añadir publicación", true);
		testUtil.textPresent("Lista de publicaciones", false);
	}
}
