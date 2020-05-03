package com.uniovi.tests.posts.create;

import java.util.Date;

import com.uniovi.pageObjects.login.POLoginIdentify;
import com.uniovi.pageObjects.posts.POCreatePost;
import com.uniovi.tests.AbstractTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreatePostWithTitleDescriptionTest extends AbstractTest {
	private final int secondsToWait = 5;
	private final String description = "Descripción de la publicación "
			+ new Date().toString();

	@Given("The user is correctly identified")
	public void the_user_is_correctly_identified() {
		String email = "cvvs@uniovi.es";
		String password = "123456";
		new POLoginIdentify(driver, testUtil, secondsToWait, email, password)
				.goToPage();
		testUtil.textPresent(
				"Su correo electrónico y | o contraseña no son válidos", false);
		testUtil.textPresent("Registrarse", false);
		testUtil.textPresent("Logout", true);
	}

	@When("access the post creation menu")
	public void access_the_post_creation_menu() {
		new POCreatePost(driver, testUtil, secondsToWait).goToPage();
		testUtil.textPresent(
				"Su correo electrónico y | o contraseña no son válidos", false);
		testUtil.textPresent("Añadir publicación", true);
	}

	@When("just enter the description")
	public void just_enter_the_description() {
		testUtil.insertDataInput("description", description);
		testUtil.changeWebClick("add");
		testUtil.waitSeconds(secondsToWait);
	}

	@Then("the application doesnt create the post")
	public void the_application_doesnt_create_the_post() {
		testUtil.textPresent("Lista de publicaciones", false);
		testUtil.textPresent(description, false);
	}

}
