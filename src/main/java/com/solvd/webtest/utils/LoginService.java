package com.solvd.webtest.utils;

import com.solvd.webtest.components.login.LoginModal;
import com.solvd.webtest.domain.User;
import com.solvd.webtest.domain.Users;
import com.solvd.webtest.page.HomePage;

public class LoginService {

    public User createUser(Users user) {
        return new User(user.getUsername(), user.getPass());
    }

    public HomePage login (User user, LoginModal loginModal) {
        loginModal.getModalBody().typeUsername(user);
        loginModal.getModalBody().typeValidPass(user);
        return loginModal.getModalFooter().clickLogin();
    }
}
