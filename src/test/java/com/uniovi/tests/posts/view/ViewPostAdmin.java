package com.uniovi.tests.posts.view;

import com.uniovi.pageObjects.login.POLoginIdentify;
import com.uniovi.pageObjects.posts.POViewPostWithOutAuthentification;
import com.uniovi.tests.AbstractTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewPostAdmin extends AbstractTest {

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
		new POViewPostWithOutAuthentification(driver, testUtil, secondsToWait)
				.goToPage();
	}

	@Then("he can view the posts without problems")
	public void he_can_view_the_posts_without_problems() {
		testUtil.textPresent("Your email and | or password is invalid", false);
		testUtil.textPresent("List of posts of Iván González Mahagamage", true);
	}

}
