package com.uniovi.tests.posts.view;

import com.uniovi.pageObjects.login.POLoginIdentify;
import com.uniovi.pageObjects.posts.POViewPostWithOutAuthentification;
import com.uniovi.tests.AbstractTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewPostNoFriend extends AbstractTest {

    @Given("User is logged")
    public void user_is_logged() {
        String email = "cvvs_no_amigo@uniovi.es";
        String password = "123456";
        new POLoginIdentify(driver, testUtil, secondsToWait, email, password)
                .goToPage();
        testUtil.textPresent("Your email and | or password is invalid", false);
        testUtil.textPresent("Signup", false);
        testUtil.textPresent("Logout", true);
    }

    @When("goes directly to the list of a non-friend user")
    public void goes_directly_to_the_list_of_a_non_friend_user() {
        new POViewPostWithOutAuthentification(driver, testUtil, secondsToWait).goToPage();
    }

    @Then("he cant view his posts")
    public void he_cant_view_his_posts() {
        testUtil.textPresent("Your email and | or password is invalid", false);
        testUtil.textPresent("List of posts of Iván González Mahagamage",
                false);
        testUtil.textPresent("This is a private area the web", true);
    }

}
