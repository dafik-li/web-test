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

    @FindBy(xpath = "//h2")
    private ExtendedWebElement headline;

    @FindBy(xpath = "//h3")
    private ExtendedWebElement price;

    @FindBy(xpath = "//div[@id = 'more-information']/p")
    private ExtendedWebElement description;

    @FindBy(xpath = "//a[contains(text(), 'Add to cart')]")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//a[@id = 'cartur']")
    private ExtendedWebElement cartLink;

    @FindBy(xpath = "//a[@id = 'nava']")
    private ExtendedWebElement toHomePageLink;


    public ProductPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(headline);
    }

    public Product getProduct() {
        Product product = new Product();
        product.setModel(headline.getText());
        product.setInformation(description.getText());
        String cost = price.getText().replace("$", "").replace(" *includes tax", "");
        product.setCost(Double.parseDouble(cost));
        return product;
    }

    public Product clickOnAddToCartButton() {
        addToCartButton.click();
        return getProduct();
    }
    public CartPage clickOnCartLink() {
        cartLink.click();
        return new CartPage(getDriver());
    }
    public HomePage clickOnToHomePageLink() {
        toHomePageLink.click();
        return new HomePage(getDriver());
    }
}
