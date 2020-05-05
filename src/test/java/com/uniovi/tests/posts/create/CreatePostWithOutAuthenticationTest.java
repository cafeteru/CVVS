package com.uniovi.tests.posts.create;

import com.uniovi.pageObjects.login.POLogin;
import com.uniovi.pageObjects.posts.POCreatePostWithOutAuthentification;
import com.uniovi.tests.AbstractTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreatePostWithOutAuthenticationTest extends AbstractTest {

    @Given("User is not identified")
    public void user_is_not_identified() {
        new POLogin(driver, testUtil, secondsToWait).goToPage();
        testUtil.textPresent("Signup", true);
        testUtil.textPresent("Logout", false);
    }

    @When("tries to access the post creation menu directly")
    public void tries_to_access_the_post_creation_menu_directly() {
        new POCreatePostWithOutAuthentification(driver, testUtil, secondsToWait)
                .goToPage();
    }

    @Then("the application will not let him in")
    public void the_application_will_not_let_him_in() {
        testUtil.textPresent(
                "Your email and | or password is invalid", false);
        testUtil.textPresent("This is a private area the web", false);
        testUtil.textPresent("Publications", false);
        testUtil.textPresent("Logout", false);
    }
}
