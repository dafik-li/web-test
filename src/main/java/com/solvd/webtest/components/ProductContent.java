package com.solvd.webtest.components;

import com.solvd.webtest.page.CartPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductContent extends AbstractUIObject {

    @FindBy(xpath = "//*[@id = 'tbodyid']/h2")
    private ExtendedWebElement model;

    @FindBy(xpath = "//*[@id = 'tbodyid']/h3")
    private ExtendedWebElement cost;

    @FindBy(xpath = "//*[@id = 'more-information']/p/text()")
    private ExtendedWebElement information;

    @FindBy(xpath = "//*[@id = 'tbodyid']/div[2]/div/a")
    private ExtendedWebElement addToCartButton;


    public ProductContent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getModel() {
        return model;
    }
    public ExtendedWebElement getCost() {
        return cost;
    }
    public ExtendedWebElement getInformation() {
        return information;
    }
    public ExtendedWebElement getAddToCartButton() {
        return addToCartButton;
    }

    public CartPage clickOnAddToCartButton() {
        getAddToCartButton().click();
        return new CartPage(getDriver());
    }
}
