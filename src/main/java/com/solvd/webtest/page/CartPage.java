package com.solvd.webtest.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//*[@class = 'success']/td[2]")
    private List<ExtendedWebElement> productsName;

    @FindBy(xpath = "//*[@id = 'totalp']")
    private ExtendedWebElement totalSum;

    @FindBy(xpath = "//button[@data-target = '#orderModal']")
    private ExtendedWebElement placeOrderButton;

    @FindBy(xpath = "//tbody[tr[@class= 'success'][1]]//a")
    private ExtendedWebElement deleteProductByIndexLink;

    public ExtendedWebElement getTotalSum() {
        return totalSum;
    }

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(placeOrderButton);
    }

    public List<String> getProductsFromCart() {
        return productsName.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    public String clickOnDeleteProductByIndexLink(int index) {
        deleteProductByIndexLink.format(index).click();
        return new ArrayList<>(getProductsFromCart()).remove(index);
    }
}