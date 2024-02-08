package com.solvd.webtest.components;

import com.solvd.webtest.page.ProductPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCard extends AbstractUIObject {

    @FindBy(xpath = "//div[@class = 'card h-100']/a[@href = 'prod.html?idp_=1']/img[@src = 'imgs/galaxy_s6.jpg']")
    private ExtendedWebElement imageLink;

    @FindBy(xpath = "//div[@class = 'card h-100']/div[@class = 'card-block']")
    private ProductBlock productBlock;

    public ProductCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getImageLink() {
        return imageLink;
    }
    public ProductBlock getProductBlock() {
        return productBlock;
    }
    public ProductPage clickImageLink() {
        getImageLink().click();
        return new ProductPage(getDriver());
    }
}
