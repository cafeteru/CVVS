package com.uniovi.tests.posts.view;

import com.uniovi.pageObjects.login.POLoginIdentify;
import com.uniovi.tests.AbstractTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewPostAdmin extends AbstractTest {
	private final int secondsToWait = 5;

	@Given("Admin is identified")
	public void admin_is_identified() {
		String email = "ivangonzalezmahagamage@gmail.com";
		String password = "123456";
		new POLoginIdentify(driver, testUtil, secondsToWait, email, password)
				.goToPage();
		testUtil.textPresent("Your email and | or password is invalid", false);
		testUtil.textPresent("Signup", false);
		testUtil.textPresent("Logout", true);
	}

	@When("tries to access a users posts")
	public void tries_to_access_a_users_posts() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("he can view the posts without problems")
	public void he_can_view_the_posts_without_problems() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
