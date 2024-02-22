package com.solvd.webtest.components.login;

import com.solvd.webtest.page.HomePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ModalFooter extends AbstractUIObject {

    @FindBy(xpath = ".//button[contains(text(), 'Close')]")
    private ExtendedWebElement buttonClose;

    @FindBy(xpath = "//button[contains(text(), 'Log in')]")
    private ExtendedWebElement buttonLogin;

    public ModalFooter(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isButtonClosePresent() {
        return buttonClose.isElementPresent();
    }
    public boolean isButtonLoginPresent() {
        return buttonLogin.isElementPresent();
    }


    public HomePage clickLogin() {
        buttonLogin.click();
        return new HomePage(driver);
    }
    public HomePage clickClose() {
        buttonClose.click();
        return new HomePage(driver);
    }
}
