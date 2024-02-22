package com.solvd.webtest.components.login;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ModalHeader extends AbstractUIObject {

    @FindBy(xpath = "//h5[@id = 'logInModalLabel']")
    private ExtendedWebElement loginTitle;

    @FindBy(xpath = "//div[@id = 'logInModal']//div[@class = 'modal-header']//button[@class = 'close']")
    private ExtendedWebElement buttonClose;

    public ModalHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isButtonClosePresent() {
        return buttonClose.isElementPresent();
    }
    public boolean isLoginTitlePresent() {
        return loginTitle.isElementPresent();
    }
}
