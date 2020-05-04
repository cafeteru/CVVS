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
    private final String title = "Title of publication "
            + new Date().toString();
    private final String description = "Description of publication "
            + new Date().toString();

    @Given("User can identified")
    public void the_user_can_identified() {
        String email = "cvvs@uniovi.es";
        String password = "123456";
        new POLoginIdentify(driver, testUtil, secondsToWait, email, password)
                .goToPage();
        testUtil.textPresent(
                "Your email and | or password is invalid", false);
        testUtil.textPresent("Signup", false);
        testUtil.textPresent("Logout", true);
    }

    @When("him access the post creation menu")
    public void him_access_the_post_creation_menu() {
        new POCreatePost(driver, testUtil, secondsToWait).goToPage();
        testUtil.textPresent(
                "Your email and | or password is invalid", false);
        testUtil.textPresent("Add publication", true);
    }

    @When("enter the title")
    public void enter_the_title() {
        testUtil.insertDataInput("title", title);
    }

    @When("enter the description")
    public void enter_the_description() {
        testUtil.insertDataInput("description", description);
    }

    @Then("the application create the post")
    public void the_application_create_the_post() {
        testUtil.changeWebClick("add");
        testUtil.waitSeconds(secondsToWait);
        testUtil.textPresent("Send", false);
        testUtil.textPresent("List of posts", true);
        testUtil.textPresent(title, true);
        testUtil.textPresent(description, true);
    }
}
