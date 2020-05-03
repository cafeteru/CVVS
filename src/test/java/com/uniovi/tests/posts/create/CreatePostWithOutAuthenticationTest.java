package com.uniovi.tests.posts.create;

import com.uniovi.pageobjects.login.POLogin;
import com.uniovi.pageobjects.posts.POCreatePostWithOutAuthentification;
import com.uniovi.tests.AbstractTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreatePostWithOutAuthenticationTest extends AbstractTest {
    private final int secondsToWait = 5;

    @Given("The user is not identified")
    public void the_user_is_not_identified() {
        new POLogin(driver, testUtil, secondsToWait).goToPage();
        testUtil.textPresent("Registrarse", true);
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
                "Su correo electrónico y | o contraseña no son válidos", false);
        testUtil.textPresent("Esta es una zona privada la web", false);
        testUtil.textPresent("Publicaciones", false);
        testUtil.textPresent("Logout", false);
    }
}
