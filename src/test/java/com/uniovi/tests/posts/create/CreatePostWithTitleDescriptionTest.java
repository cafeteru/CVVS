package com.uniovi.tests.posts.create;

import com.uniovi.pageObjects.posts.POCreatePost;
import com.uniovi.tests.AbstractTest;
import org.junit.jupiter.api.Test;

public class CreatePostWithTitleDescriptionTest extends AbstractTest {

    @Test
    public void test() {
        String email = "cvvs@uniovi.es";
        String password = "123456";
        new POCreatePost(driver, testUtil, email, password).goToPage();
        testUtil.textPresent(
                "Su correo electrónico y | o contraseña no son válidos", false);
        testUtil.textPresent(
                "Añadir publicación", true);
        String title = "Titulo de la publicación";
        testUtil.insertDataInput("title", title);
        testUtil.changeWebClick("add");
        testUtil.waitSeconds(5);
        testUtil.textPresent("Lista de publicaciones", false);
        testUtil.textPresent(title, false);
    }
}
