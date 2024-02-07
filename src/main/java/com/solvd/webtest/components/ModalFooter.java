package com.solvd.webtest.components;

import com.solvd.webtest.page.HomePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ModalFooter extends AbstractUIObject {

    @FindBy(xpath = "//div[@id = 'logInModal']//div[@class = 'modal-footer']//button[contains(text(), 'Close')]")
    ExtendedWebElement buttonClose;

    @FindBy(xpath = "//button[@onclick = 'send()']")
    ExtendedWebElement buttonLogin;


    public ModalFooter(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public ExtendedWebElement getButtonClose() {
        return buttonClose;
    }
    public ExtendedWebElement getButtonLogin() {
        return buttonLogin;
    }


    public HomePage clickLogin() {
        buttonLogin.click();
        return new HomePage(getDriver());
    }
    public HomePage clickClose() {
        buttonClose.click();
        return new HomePage(getDriver());
    }
}
