package com.solvd.webtest.components.login;

import com.solvd.webtest.domain.User;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ModalBody extends AbstractUIObject {


    @FindBy(xpath = "//label[@for = 'log-name']")
    private ExtendedWebElement logUsername;

    @FindBy(xpath = "//input[@id = 'loginusername']")
    private ExtendedWebElement inputUsername;

    @FindBy(xpath = "//div[@class = 'form-group'][2]//label[@for = 'log-pass']")
    private ExtendedWebElement logPass;

    @FindBy(xpath = "//label[@id = 'errorl']")
    private ExtendedWebElement invalidPass;

    @FindBy(xpath = "//input[@id = 'loginpassword']")
    private ExtendedWebElement inputPass;


    public ModalBody(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isLogUsernamePresent() {
        return logUsername.isElementPresent();
    }
    public boolean isLogPassPresent() {
        return logPass.isElementPresent();
    }
    public boolean isInputUsernamePresent() {
        return inputUsername.isElementPresent();
    }
    public boolean isInputPassPresent() {
        return inputPass.isElementPresent();
    }


    public ModalBody typeUsername(User user) {
        inputUsername.type(user.getUsername());
        return this;
    }
    public ModalBody typeValidPass(User user) {
        inputPass.type(user.getPass());
        return this;
    }
    public String typeInvalidPass() {
        return invalidPass.getText();
    }
}