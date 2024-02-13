package com.solvd.webtest.page;

import com.solvd.webtest.domain.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends AbstractPage {

    private final ProductPage productPage = new ProductPage(getDriver());

    @FindBy(xpath = "//*[@class = 'success']/td[2]")
    private List<ExtendedWebElement> productsName;

    @FindBy(xpath = "//*[@id = 'totalp']")
    private ExtendedWebElement totalSum;

    @FindBy(xpath = "//button[@data-target = '#orderModal']")
    private ExtendedWebElement placeOrderButton;

    @FindBy(xpath = "//*[@class = 'success']/td[4]/a[%d]")
    private ExtendedWebElement deleteProductByIndexLink;

    public List<ExtendedWebElement> getProductsName() {
        return productsName;
    }
    public ExtendedWebElement getTotalSum() {
        return totalSum;
    }
    public ExtendedWebElement getPlaceOrderButton() {
        return placeOrderButton;
    }
    public ExtendedWebElement getDeleteProductByIndexLink() {
        return deleteProductByIndexLink;
    }

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(getPlaceOrderButton());
    }

    public List<String> getProductsFromCart() {
        return getProductsName().stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    public String clickOnDeleteProductByIndexLink(int index) {
        getDeleteProductByIndexLink().format(index).click();
        return new ArrayList<>(getProductsFromCart()).remove(index);
    }
}