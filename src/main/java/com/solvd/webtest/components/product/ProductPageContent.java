/*package com.solvd.webtest.components.product;

import com.solvd.webtest.page.CartPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPageContent extends AbstractUIObject {

    @FindBy(xpath = "//*[@class = 'name']")
    private ExtendedWebElement headline;

    @FindBy(xpath = "//*[@class = 'price-container']")
    private ExtendedWebElement price;

    @FindBy(xpath = "//*[@id = 'more-information']/p/text()")
    private ExtendedWebElement description;

    @FindBy(xpath = "//div[2]/div/a")
    private ExtendedWebElement addToCartButtonByIndex;


    public ProductPageContent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getHeadline() {
        return headline;
    }
    public ExtendedWebElement getPrice() {
        return price;
    }
    public ExtendedWebElement getDescription() {
        return description;
    }
    public ExtendedWebElement getAddToCartButtonByIndex() {
        return addToCartButtonByIndex;
    }

    public CartPage clickOnAddToCartButtonByIndex(int index) {
        getAddToCartButtonByIndex().format(index).click();
        return new CartPage(getDriver());
    }
}

 */
