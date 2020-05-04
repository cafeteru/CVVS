package com.uniovi.tests.posts.create;

import java.util.Date;

import com.uniovi.pageObjects.login.POLoginIdentify;
import com.uniovi.pageObjects.posts.POCreatePost;
import com.uniovi.tests.AbstractTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreatePostWithTitleDescriptionTooBigTest extends AbstractTest {
	private final int secondsToWait = 5;
	private final String title = "Title of publication "
			+ new Date().toString();
	private String description = "";

	@Given("User login correctly")
	public void user_login_correctly() {
		String email = "cvvs@uniovi.es";
		String password = "123456";
		new POLoginIdentify(driver, testUtil, secondsToWait, email, password)
				.goToPage();
		testUtil.textPresent("Your email and | or password is invalid", false);
		testUtil.textPresent("Signup", false);
		testUtil.textPresent("Logout", true);
	}

	@When("he goes to the post creation menu again")
	public void he_goes_to_the_post_creation_menu_again() {
		new POCreatePost(driver, testUtil, secondsToWait).goToPage();
		testUtil.textPresent("Your email and | or password is invalid", false);
		testUtil.textPresent("Add publication", true);
	}

	@When("enter a title")
	public void enter_a_title() {
		testUtil.insertDataInput("title", title);
	}

	@When("enter a description correctly")
	public void enter_a_description_correctly() {
		while (description.length() <= 255) {
			description += 1;
		}
		testUtil.insertDataInput("description", description);
	}

	@Then("the application can create the post correctly")
	public void the_application_can_create_the_post_correctly() {
		testUtil.changeWebClick("add");
		testUtil.waitSeconds(secondsToWait);
		testUtil.textPresent("Send", false);
		testUtil.textPresent("List of posts", true);
		testUtil.textPresent(title, true);
		testUtil.textPresent(description, true);
	}

}
