package com.uniovi.tests.posts.create;

import java.util.Date;

import com.uniovi.pageObjects.login.POLoginIdentify;
import com.uniovi.pageObjects.posts.POCreatePost;
import com.uniovi.tests.AbstractTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreatePostTitleDescriptionPhotoTest extends AbstractTest {
	private final String title = "Title of publication "
			+ new Date().toString();
	private final String description = "Description of publication "
			+ new Date().toString();
	private final String url = "https://i.ytimg.com/vi/8PvyIAEfPgE/maxresdefault.jpg";
	private final String image = "photo.jpg";

	@Given("user identifies")
	public void user_identifies() {
		String email = "cvvs@uniovi.es";
		String password = "123456";
		new POLoginIdentify(driver, testUtil, secondsToWait, email, password)
				.goToPage();
		testUtil.textPresent("Your email and | or password is invalid", false);
		testUtil.textPresent("Signup", false);
		testUtil.textPresent("Logout", true);
	}

	@When("she goes to the post creation menu")
	public void she_goes_to_the_post_creation_menu() {
		new POCreatePost(driver, testUtil, secondsToWait).goToPage();
		testUtil.textPresent("Your email and | or password is invalid", false);
		testUtil.textPresent("Add publication", true);
	}

	@And("write the title")
	public void write_the_title() {
		testUtil.insertDataInput("title", title);
	}

	@And("write the description")
	public void write_the_description() {
		testUtil.insertDataInput("description", description);
	}

	@And("add a photo")
	public void add_a_photo() {
		getFilesInternet.insertImgToFile(url, image);
	}

	@Then("the application save the post")
	public void the_application_save_the_post() {
		testUtil.changeWebClick("add");
		testUtil.waitSeconds(secondsToWait);
		testUtil.textPresent("Send", false);
		testUtil.textPresent("List of posts", true);
		testUtil.textPresent(title, true);
		testUtil.textPresent(description, true);
	}

}
