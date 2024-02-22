package com.solvd.webtest;

import com.solvd.webtest.components.login.LoginModal;
import com.solvd.webtest.components.login.ModalBody;
import com.solvd.webtest.components.login.ModalFooter;
import com.solvd.webtest.components.login.ModalHeader;
import com.solvd.webtest.domain.Users;
import com.solvd.webtest.page.HomePage;
import com.solvd.webtest.utils.LoginService;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends AbstractTest {

    private final LoginService loginService = new LoginService();

    @Test(description = "verify login with valid data")
    public void verifyValidLoginTest() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = getHomePage();

        sa.assertTrue(homePage.isLoginLinkPresent(), "login link is not present");
        sa.assertTrue(homePage.isSignUpLinkPresent(), "sign up link is not present");
        sa.assertFalse(homePage.isNameOfUserLinkPresent(), "name of user link is present");
        sa.assertFalse(homePage.isNameOfUserLinkDisplayed(), "name of user link is displayed");
        sa.assertFalse(homePage.isLogoutLinkPresent(), "logout link is present");
        sa.assertFalse(homePage.isLogoutLinkDisplayed(), "logout link is displayed");

        LoginModal loginModal = homePage.clickLoginLink();
        sa.assertTrue(loginModal.isUIObjectPresent(), "login modal is not present");
        sa.assertTrue(loginModal.isModalHeaderUIPresent(), "header is not present");
        sa.assertTrue(loginModal.isModalBodyUIPresent(), "body is not present");
        sa.assertTrue(loginModal.isModalFooterUIPresent(), "footer is not present");

        ModalHeader modalHeader = loginModal.getModalHeader();
        sa.assertTrue(modalHeader.isLoginTitlePresent(), "login title is not present");
        sa.assertTrue(modalHeader.isButtonClosePresent(), "button close is not present");

        ModalBody modalBody = loginModal.getModalBody();
        sa.assertTrue(modalBody.isLogUsernamePresent(), "username title is not present");
        sa.assertTrue(modalBody.isLogPassPresent(), "password title is not present");
        sa.assertTrue(modalBody.isInputUsernamePresent(), "username input field is not present");
        sa.assertTrue(modalBody.isInputPassPresent(), "password input field is not present");

        ModalFooter modalFooter = loginModal.getModalFooter();
        sa.assertTrue(modalFooter.isButtonClosePresent(), "button close is not present");
        sa.assertTrue(modalFooter.isButtonLoginPresent(), "button login is not present");

        loginService.login(loginService.createUser(Users.VALID), loginModal);
        sa.assertTrue(homePage.isNameOfUserLinkPresentWithText(), "name of user link is not present");
        sa.assertTrue(homePage.isNameOfUserLinkDisplayed(), "name of user link is not displayed");
        sa.assertFalse(homePage.isLoginLinkPresent(), "login link is present");
        sa.assertFalse(homePage.isLoginLinkDisplayed(), "login link is displayed");
        sa.assertFalse(homePage.isSignUpLinkPresent(), "sign up link is present");
        sa.assertFalse(homePage.isSignUpLinkDisplayed(), "sign up link is displayed");
        sa.assertTrue(homePage.isLogoutLinkPresent(), "logout link is not present");
        sa.assertTrue(homePage.isLogoutLinkDisplayed(), "logout link is not displayed");

        sa.assertAll();
    }

    @Test(description = "verify login with invalid data")
    public void verifyInvalidLoginTest() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = getHomePage();

        sa.assertTrue(homePage.isLoginLinkPresent(), "login link is not present");
        sa.assertTrue(homePage.isSignUpLinkPresent(), "sign up link is not present");
        sa.assertFalse(homePage.isNameOfUserLinkPresent(), "name of user link is present");
        sa.assertFalse(homePage.isNameOfUserLinkDisplayed(), "name of user link is displayed");
        sa.assertFalse(homePage.isLogoutLinkPresent(), "logout link is present");
        sa.assertFalse(homePage.isLogoutLinkDisplayed(), "logout link is displayed");

        LoginModal loginModal = homePage.clickLoginLink();
        sa.assertTrue(loginModal.isUIObjectPresent(), "login modal is not present");
        sa.assertTrue(loginModal.isModalHeaderUIPresent(), "header is not present");
        sa.assertTrue(loginModal.isModalBodyUIPresent(), "body is not present");
        sa.assertTrue(loginModal.isModalFooterUIPresent(), "footer is not present");

        ModalHeader modalHeader = loginModal.getModalHeader();
        sa.assertTrue(modalHeader.isLoginTitlePresent(), "login title is not present");
        sa.assertTrue(modalHeader.isButtonClosePresent(), "button close is not present");

        ModalBody modalBody = loginModal.getModalBody();
        sa.assertTrue(modalBody.isLogUsernamePresent(), "username title is not present");
        sa.assertTrue(modalBody.isLogPassPresent(), "password title is not present");
        sa.assertTrue(modalBody.isInputUsernamePresent(), "username input field is not present");
        sa.assertTrue(modalBody.isInputPassPresent(), "password input field is not present");

        ModalFooter modalFooter = loginModal.getModalFooter();
        sa.assertTrue(modalFooter.isButtonClosePresent(), "button close is not present");
        sa.assertTrue(modalFooter.isButtonLoginPresent(), "button login is not present");

        loginService.login(loginService.createUser(Users.INVALID), loginModal);

        sa.assertAll();
    }

    @Test(description = "verify logout")
    public void verifyLogoutTest() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = getHomePage();

        sa.assertTrue(homePage.isLoginLinkPresent(), "login link is not present");
        sa.assertTrue(homePage.isSignUpLinkPresent(), "sign up link is not present");
        sa.assertFalse(homePage.isNameOfUserLinkPresent(), "name of user link is present");
        sa.assertFalse(homePage.isNameOfUserLinkDisplayed(), "name of user link is displayed");
        sa.assertFalse(homePage.isLogoutLinkPresent(), "logout link is present");
        sa.assertFalse(homePage.isLogoutLinkDisplayed(), "logout link is displayed");

        LoginModal loginModal = homePage.clickLoginLink();
        sa.assertTrue(loginModal.isUIObjectPresent(), "login modal is not present");
        sa.assertTrue(loginModal.isModalHeaderUIPresent(), "header is not present");
        sa.assertTrue(loginModal.isModalBodyUIPresent(), "body is not present");
        sa.assertTrue(loginModal.isModalFooterUIPresent(), "footer is not present");

        ModalHeader modalHeader = loginModal.getModalHeader();
        sa.assertTrue(modalHeader.isLoginTitlePresent(), "login title is not present");
        sa.assertTrue(modalHeader.isButtonClosePresent(), "button close is not present");

        ModalBody modalBody = loginModal.getModalBody();
        sa.assertTrue(modalBody.isLogUsernamePresent(), "username title is not present");
        sa.assertTrue(modalBody.isLogPassPresent(), "password title is not present");
        sa.assertTrue(modalBody.isInputUsernamePresent(), "username input field is not present");
        sa.assertTrue(modalBody.isInputPassPresent(), "password input field is not present");

        ModalFooter modalFooter = loginModal.getModalFooter();
        sa.assertTrue(modalFooter.isButtonClosePresent(), "button close is not present");
        sa.assertTrue(modalFooter.isButtonLoginPresent(), "button login is not present");

        loginService.login(loginService.createUser(Users.VALID), loginModal);
        sa.assertTrue(homePage.isNameOfUserLinkPresentWithText(), "name of user link is not present");
        sa.assertTrue(homePage.isNameOfUserLinkDisplayed(), "name of user link is not displayed");
        sa.assertFalse(homePage.isLoginLinkPresent(), "login link is present");
        sa.assertFalse(homePage.isLoginLinkDisplayed(), "login link is displayed");
        sa.assertFalse(homePage.isSignUpLinkPresent(), "sign up link is present");
        sa.assertFalse(homePage.isSignUpLinkDisplayed(), "sign up link is displayed");
        sa.assertTrue(homePage.isLogoutLinkPresent(), "logout link is not present");
        sa.assertTrue(homePage.isLogoutLinkDisplayed(), "logout link is not displayed");

        homePage.clickLogoutLink();
        sa.assertTrue(homePage.isLoginLinkPresent(), "login link is not present");
        sa.assertTrue(homePage.isSignUpLinkPresent(), "sign up link is not present");
        sa.assertFalse(homePage.isNameOfUserLinkPresent(), "name of user link is present");
        sa.assertFalse(homePage.isNameOfUserLinkDisplayed(), "name of user link is displayed");
        sa.assertFalse(homePage.isLogoutLinkPresent(), "logout link is present");
        sa.assertFalse(homePage.isLogoutLinkDisplayed(), "logout link is displayed");

        sa.assertAll();
    }

    private HomePage getHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "page is not opened");
        return homePage;
    }
}
