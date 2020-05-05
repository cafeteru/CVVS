package com.uniovi.pageObjects.posts;

import com.uniovi.pageObjects.POAbstract;
import com.uniovi.util.TestUtil;
import org.openqa.selenium.WebDriver;

public class POViewPostWithOutAuthentification extends POAbstract {

    public POViewPostWithOutAuthentification(WebDriver driver,
                                             TestUtil testUtil, int secondsToWait) {
        super(driver, testUtil, secondsToWait);
    }

    @Override
    public void goToPage() {
        testUtil.changeWebUrl("http://localhost:8090/post/friends/10005");
        testUtil.waitSeconds(secondsToWait);
    }
}
