package com.solvd.webtest.page;

import com.solvd.webtest.components.ProductContent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//div[@class = 'product-content product-wrap clearfix product-deatil']")
    private ProductContent productContent;

    @FindBy(xpath = "//div[@class = 'carousel-inner']")
    private ExtendedWebElement image;


    public ProductContent getProductContent() {
        return productContent;
    }
    public ExtendedWebElement getImage() {
        return image;
    }
    public ProductPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
    }
}
