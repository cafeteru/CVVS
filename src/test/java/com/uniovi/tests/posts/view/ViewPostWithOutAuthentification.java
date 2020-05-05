package com.uniovi.tests.posts.view;

import com.uniovi.pageObjects.login.POLogin;
import com.uniovi.pageObjects.posts.POViewPostWithOutAuthentification;
import com.uniovi.tests.AbstractTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewPostWithOutAuthentification extends AbstractTest {

	@Given("User isnt identified")
	public void user_isnt_identified() {
		new POLogin(driver, testUtil, secondsToWait).goToPage();
		testUtil.textPresent("Signup", true);
		testUtil.textPresent("Logout", false);
	}

	@When("tries to access the post view menu directly")
	public void tries_to_access_the_post_view_menu_directly() {
		new POViewPostWithOutAuthentification(driver, testUtil, secondsToWait)
				.goToPage();
	}

	@Then("the application wont let him in")
	public void the_application_wont_let_him_in() {
		testUtil.textPresent("Your email and | or password is invalid", false);
		testUtil.textPresent("This is a private area the web", false);
		testUtil.textPresent("Publications", false);
		testUtil.textPresent("Logout", false);
	}

}
