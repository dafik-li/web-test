package com.solvd.webtest.page;

import com.solvd.webtest.domain.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {


    @FindBy(xpath = "//img[@src = 'imgs/galaxy_s6.jpg']")
    private ExtendedWebElement image;

    @FindBy(xpath = "//*[@class = 'name']")
    private ExtendedWebElement headline;

    @FindBy(xpath = "//*[@class = 'price-container']")
    private ExtendedWebElement price;

    @FindBy(xpath = "//*[@id = 'more-information']/p/text()")
    private ExtendedWebElement description;

    @FindBy(xpath = "//div[2]/div/a")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//*[@id = 'cartur']")
    private ExtendedWebElement cartLink;

    @FindBy(xpath = "//*[@id = 'nava']")
    private ExtendedWebElement toHomePageLink;


    public ExtendedWebElement getImage() {
        return image;
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
    public ExtendedWebElement getAddToCartButton() {
        return addToCartButton;
    }
    public ExtendedWebElement getCartLink() {
        return cartLink;
    }
    public ExtendedWebElement getToHomePageLink() {
        return toHomePageLink;
    }

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(getHeadline());
    }

    public Product getProduct() {
        Product product = new Product();
        product.setModel(getHeadline().getText());
        product.setInformation(getDescription().getText());
        String cost = getPrice().getText().replace("$", "");
        product.setCost(Double.parseDouble(cost));
        return product;
    }

    public Product clickOnAddToCartButton() {
        getAddToCartButton().click();
        return getProduct();
    }
    public CartPage clickOnCartLink() {
        getCartLink().click();
        return new CartPage(getDriver());
    }
    public HomePage clickOnToHomePageLink() {
        getToHomePageLink().click();
        return new HomePage(getDriver());
    }
}
