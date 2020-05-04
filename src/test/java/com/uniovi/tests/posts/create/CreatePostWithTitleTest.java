package com.uniovi.tests.posts.create;

import java.util.Date;

import com.uniovi.pageObjects.login.POLoginIdentify;
import com.uniovi.pageObjects.posts.POCreatePost;
import com.uniovi.tests.AbstractTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreatePostWithTitleTest extends AbstractTest {
    private final int secondsToWait = 5;
    private final String title = "Title of publication "
            + new Date().toString();

    @Given("User is identified")
    public void the_user_is_identified() {
        String email = "cvvs@uniovi.es";
        String password = "123456";
        new POLoginIdentify(driver, testUtil, secondsToWait, email, password)
                .goToPage();
        testUtil.textPresent(
                "Your email and | or password is invalid", false);
        testUtil.textPresent("Signup", false);
        testUtil.textPresent("Logout", true);
    }

    @When("tries to access the post creation menu")
    public void tries_to_access_the_post_creation_menu() {
        new POCreatePost(driver, testUtil, secondsToWait).goToPage();
        testUtil.textPresent(
                "Your email and | or password is invalid", false);
        testUtil.textPresent("Add publication", true);
    }

    @When("just enter the title")
    public void just_enter_the_title() {
        testUtil.insertDataInput("title", title);
    }

    @Then("the application does not create the post")
    public void the_application_does_not_create_the_post() {
        testUtil.changeWebClick("add");
        testUtil.waitSeconds(secondsToWait);
        testUtil.textPresent("Add publication", true);
        testUtil.textPresent("List of posts", false);
    }
}
