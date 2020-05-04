package com.uniovi.tests.posts.view;

import com.uniovi.pageObjects.login.POLoginIdentify;
import com.uniovi.tests.AbstractTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewPostFriend extends AbstractTest {
	private final int secondsToWait = 5;

	@Given("User is identified within the application")
	public void user_is_identified_within_the_application() {
		String email = "cvvs@uniovi.es";
		String password = "123456";
		new POLoginIdentify(driver, testUtil, secondsToWait, email, password)
				.goToPage();
		testUtil.textPresent("Your email and | or password is invalid", false);
		testUtil.textPresent("Signup", false);
		testUtil.textPresent("Logout", true);
	}

	@When("goes to his friends list")
	public void goes_to_his_friends_list() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("select one of them")
	public void select_one_of_them() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("he can view his posts")
	public void he_can_view_his_posts() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
