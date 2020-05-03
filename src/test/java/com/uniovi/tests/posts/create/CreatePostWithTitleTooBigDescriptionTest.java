package com.uniovi.tests.posts.create;

import com.uniovi.pageobjects.login.POLoginIdentify;
import com.uniovi.pageobjects.posts.POCreatePost;
import com.uniovi.tests.AbstractTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Date;

public class CreatePostWithTitleTooBigDescriptionTest extends AbstractTest {
    private final int secondsToWait = 5;
    private String title = "";
    private final String description = "Description of publication "
            + new Date().toString();

    @Given("User login")
    public void user_login() {
        String email = "cvvs@uniovi.es";
        String password = "123456";
        new POLoginIdentify(driver, testUtil, secondsToWait, email, password)
                .goToPage();
        testUtil.textPresent(
                "Your email and | or password is invalid", false);
        testUtil.textPresent("Signup", false);
        testUtil.textPresent("Logout", true);
    }

    @When("he goes to the post creation menu")
    public void he_goes_to_the_post_creation_menu() {
        new POCreatePost(driver, testUtil, secondsToWait).goToPage();
        testUtil.textPresent(
                "Your email and | or password is invalid", false);
        testUtil.textPresent("Add publication", true);
    }

    @When("enter a title too big")
    public void enter_a_title_too_big() {
        while (title.length() <= 255) {
            title += 1;
        }
        testUtil.insertDataInput("title", title);
    }

    @When("enter a description")
    public void enter_a_description() {
        testUtil.insertDataInput("description", description);
    }

    @Then("the application can create the post")
    public void the_application_can_create_the_post() {
        testUtil.changeWebClick("add");
        testUtil.waitSeconds(secondsToWait);
        testUtil.textPresent("Send", false);
        testUtil.textPresent("List of posts", true);
        testUtil.textPresent(title, true);
        testUtil.textPresent(description, true);
    }

}
