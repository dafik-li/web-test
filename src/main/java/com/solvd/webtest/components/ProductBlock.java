package com.solvd.webtest.components;

import com.solvd.webtest.page.ProductPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductBlock extends AbstractUIObject {

    @FindBy(xpath = "//div[@class = 'card h-100']/div[@class = 'card-block']/h4[@class = 'card-title']/a[@href = 'prod.html?idp_=1']")
    private ExtendedWebElement titleLink;

    @FindBy(xpath = "//div[@class = 'card h-100']//div[@class = 'card-block']//h5[contains(text(), '$360')]")
    private ExtendedWebElement price;

    @FindBy(xpath = "//div[@class = 'card h-100']//div[@class = 'card-block']//p[@id = 'article']/text()")
    private ExtendedWebElement description;

    public ProductBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getTitleLink() {
        return titleLink;
    }
    public ExtendedWebElement getPrice() {
        return price;
    }
    public ExtendedWebElement getDescription() {
        return description;
    }
    public ProductPage clickTitleLink() {
        getTitleLink().click();
        return new ProductPage(getDriver());
    }
}
