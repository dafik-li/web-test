package com.solvd.webtest.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ModalHeader extends AbstractUIObject {

    @FindBy(xpath = "//h5[@id = 'logInModalLabel']")
    ExtendedWebElement loginTitle;

    @FindBy(xpath = "//div[@id = 'logInModal']//div[@class = 'modal-header']//button[@class = 'close']")
    ExtendedWebElement buttonClose;


    public ModalHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public ExtendedWebElement getLoginTitle() {
        return loginTitle;
    }
    public ExtendedWebElement getButtonClose() {
        return buttonClose;
    }
}
