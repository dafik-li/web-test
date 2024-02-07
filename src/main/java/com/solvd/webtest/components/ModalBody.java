package com.solvd.webtest.components;

import com.solvd.webtest.domain.User;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ModalBody extends AbstractUIObject {

    @FindBy(xpath = "//div[@id = 'logInModal']//div[@class = 'modal-body']//label[@for = 'log-name']")
    ExtendedWebElement logUsername;

    @FindBy(xpath = "//input[@id = 'loginusername']")
    ExtendedWebElement inputUsername;

    @FindBy(xpath = "//div[@id = 'logInModal']//div[@class = 'modal-body']//label[@for = 'log-pass']")
    ExtendedWebElement logPass;

    @FindBy(xpath = "//div[@id = 'logInModal']//div[@class = 'modal-body']//label[@id = 'errorl']")
    ExtendedWebElement invalidPass;

    @FindBy(xpath = "//input[@id = 'loginpassword']")
    ExtendedWebElement inputPass;


    public ModalBody(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public ExtendedWebElement getLogUsername() {
        return logUsername;
    }
    public ExtendedWebElement getInputUsername() {
        return inputUsername;
    }
    public ExtendedWebElement getLogPass() {
        return logPass;
    }
    public ExtendedWebElement getInvalidPass() {
        return invalidPass;
    }
    public ExtendedWebElement getInputPass() {
        return inputPass;
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