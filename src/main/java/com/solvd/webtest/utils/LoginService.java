package com.solvd.webtest.utils;

import com.solvd.webtest.domain.User;
import com.solvd.webtest.page.HomePage;
import org.openqa.selenium.WebDriver;

public class LoginService {

    public User createUser(User user) {
        return new User(user.getUsername(), user.getPass());
    }

    public HomePage login(User user, WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        homePage.getLoginModal().getModalBody().typeUsername(user);
        homePage.getLoginModal().getModalBody().typeValidPass(user);
        return homePage.getLoginModal().getModalFooter().clickLogin();
    }

}
