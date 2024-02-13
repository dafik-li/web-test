package com.solvd.webtest;

import com.solvd.webtest.components.login.LoginModal;
import com.solvd.webtest.components.login.ModalBody;
import com.solvd.webtest.components.login.ModalFooter;
import com.solvd.webtest.components.login.ModalHeader;
import com.solvd.webtest.domain.Users;
import com.solvd.webtest.page.HomePage;
import com.solvd.webtest.utils.LoginService;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends AbstractTest {

    private final LoginService loginService = new LoginService();


    @Test(description = "verify login with valid data")
    public void verifyValidLoginTest() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        sa.assertTrue(homePage.isPageOpened(), "page is not opened");

        sa.assertTrue(homePage.getLoginLink().isElementPresent(), "login link is not present");
        sa.assertTrue(homePage.getSignUpLink().isElementPresent(), "sign up link is not present");
        sa.assertTrue(homePage.getNameOfUserLink().isElementNotPresent(1), "name of user link is present");
        sa.assertTrue(homePage.getLogoutLink().isElementNotPresent(1), "logout link is present");

        LoginModal loginModal = homePage.clickLoginLink();
        sa.assertTrue(loginModal.isUIObjectPresent(), "login modal is not present");
        sa.assertTrue(loginModal.getModalHeader().isUIObjectPresent(), "header is not present");
        sa.assertTrue(loginModal.getModalBody().isUIObjectPresent(), "body is not present");
        sa.assertTrue(loginModal.getModalFooter().isUIObjectPresent(), "footer is not present");

        ModalHeader modalHeader = loginModal.getModalHeader();
        sa.assertTrue(modalHeader.getLoginTitle().isElementPresent(), "login title is not present");
        sa.assertTrue(modalHeader.getButtonClose().isElementPresent(), "button close is not present");

        ModalBody modalBody = loginModal.getModalBody();
        sa.assertTrue(modalBody.getLogUsername().isElementPresent(), "username title is not present");
        sa.assertTrue(modalBody.getLogPass().isElementPresent(), "password title is not present");
        sa.assertTrue(modalBody.getInputUsername().isElementPresent(), "username input field is not present");
        sa.assertTrue(modalBody.getInputPass().isElementPresent(), "password input field is not present");

        ModalFooter modalFooter = loginModal.getModalFooter();
        sa.assertTrue(modalFooter.getButtonClose().isElementPresent(), "button close is not present");
        sa.assertTrue(modalFooter.getButtonLogin().isElementPresent(), "button login is not present");

        loginService.login(loginService.createUser(Users.VALID), loginModal);
        sa.assertTrue(homePage.getLogoutLink().isElementPresent(), "logout link is not present");
        sa.assertTrue(homePage.getNameOfUserLink().isElementWithTextPresent("Welcome " + R.TESTDATA.get("valid.username")), "name of user link is not present");
        sa.assertTrue(homePage.getLoginLink().isElementNotPresent(1), "login link is present");
        sa.assertTrue(homePage.getSignUpLink().isElementNotPresent(1), "sign up link is present");

        sa.assertAll();
    }

    @Test(description = "verify login with invalid data")
    public void verifyInvalidLoginTest() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        sa.assertTrue(homePage.isPageOpened(), "page is not opened");

        sa.assertTrue(homePage.getLoginLink().isElementPresent(), "login link is not present");
        sa.assertTrue(homePage.getSignUpLink().isElementPresent(), "sign up link is not present");
        sa.assertTrue(homePage.getNameOfUserLink().isElementNotPresent(1), "name of user link is present");
        sa.assertTrue(homePage.getLogoutLink().isElementNotPresent(1), "logout link is present");

        LoginModal loginModal = homePage.clickLoginLink();
        sa.assertTrue(loginModal.isUIObjectPresent(), "login modal is not present");
        sa.assertTrue(loginModal.getModalHeader().isUIObjectPresent(), "header is not present");
        sa.assertTrue(loginModal.getModalBody().isUIObjectPresent(), "body is not present");
        sa.assertTrue(loginModal.getModalFooter().isUIObjectPresent(), "footer is not present");

        ModalHeader modalHeader = loginModal.getModalHeader();
        sa.assertTrue(modalHeader.getLoginTitle().isElementPresent(), "login title is not present");
        sa.assertTrue(modalHeader.getButtonClose().isElementPresent(), "button close is not present");

        ModalBody modalBody = loginModal.getModalBody();
        sa.assertTrue(modalBody.getLogUsername().isElementPresent(), "username title is not present");
        sa.assertTrue(modalBody.getLogPass().isElementPresent(), "password title is not present");
        sa.assertTrue(modalBody.getInputUsername().isElementPresent(), "username input field is not present");
        sa.assertTrue(modalBody.getInputPass().isElementPresent(), "password input field is not present");

        ModalFooter modalFooter = loginModal.getModalFooter();
        sa.assertTrue(modalFooter.getButtonClose().isElementPresent(), "button close is not present");
        sa.assertTrue(modalFooter.getButtonLogin().isElementPresent(), "button login is not present");

        loginService.login(loginService.createUser(Users.INVALID), loginModal);

        sa.assertAll();
    }

    @Test(description = "verify logout")
    public void verifyLogoutTest() {
        SoftAssert sa = new SoftAssert();
        verifyValidLoginTest();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickLogoutLink();
        sa.assertTrue(homePage.getLoginLink().isElementPresent(), "");
        sa.assertTrue(homePage.getSignUpLink().isElementPresent(), "");
        sa.assertTrue(homePage.getLogoutLink().isElementNotPresent(1), "");
        sa.assertTrue(homePage.getNameOfUserLink().isElementNotPresent(1), "");

        sa.assertAll();
    }
}
