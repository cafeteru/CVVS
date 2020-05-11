package com.uniovi.tests.posts.create;

import java.util.Date;

import com.uniovi.pageObjects.login.POLoginIdentify;
import com.uniovi.pageObjects.posts.POCreatePost;
import com.uniovi.tests.AbstractTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreatePostDescriptionTest extends AbstractTest {
	private final String description = "Description of publication "
			+ new Date().toString();

	@Given("User is correctly identified")
	public void user_is_correctly_identified() {
		String email = "cvvs@uniovi.es";
		String password = "123456";
		new POLoginIdentify(driver, testUtil, secondsToWait, email, password)
				.goToPage();
		testUtil.textPresent("Your email and | or password is invalid", false);
		testUtil.textPresent("Signup", false);
		testUtil.textPresent("Logout", true);
	}

	@When("access the post creation menu")
	public void access_the_post_creation_menu() {
		new POCreatePost(driver, testUtil, secondsToWait).goToPage();
		testUtil.textPresent("Your email and | or password is invalid", false);
		testUtil.textPresent("Add publication", true);
	}

	@And("just enter the description")
	public void just_enter_the_description() {
		testUtil.insertDataInput("description", description);
	}

	@Then("the application doesnt create the post")
	public void the_application_doesnt_create_the_post() {
		testUtil.changeWebClick("add");
		testUtil.waitSeconds(secondsToWait);
		testUtil.textPresent("Add publication", true);
		testUtil.textPresent("List of posts", false);
	}
}
