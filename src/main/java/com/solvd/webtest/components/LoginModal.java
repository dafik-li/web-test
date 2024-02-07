package com.solvd.webtest.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginModal extends AbstractUIObject {

    @FindBy(xpath = "//div[@id = 'logInModal']//div[@class = 'modal-header']")
    private ModalHeader modalHeader;

    @FindBy(xpath = "//div[@id = 'logInModal']//div[@class = 'modal-body']")
    private ModalBody modalBody;

    @FindBy(xpath = "//div[@id = 'logInModal']//div[@class = 'modal-footer']")
    private ModalFooter modalFooter;



    public LoginModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }



    public ModalHeader getModalHeader() {
        return modalHeader;
    }
    public ModalBody getModalBody() {
        return modalBody;
    }
    public ModalFooter getModalFooter() {
        return modalFooter;
    }
}