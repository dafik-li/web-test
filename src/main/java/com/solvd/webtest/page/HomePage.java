package com.solvd.webtest.page;

import com.solvd.webtest.components.login.LoginModal;
import com.solvd.webtest.domain.Product;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//a[@id = 'login2']")
    private ExtendedWebElement loginLink;

    @FindBy(xpath = "//div[@id = 'logInModal']")
    private LoginModal loginModal;

    @FindBy(xpath = "//a[@id = 'signin2']")
    private ExtendedWebElement signUpLink;

    @FindBy(xpath = "//a[@id = 'nameofuser']")
    private ExtendedWebElement nameOfUserLink;

    @FindBy(xpath = "//a[@id = 'logout2']")
    private ExtendedWebElement logoutLink;

    @FindBy(xpath = "//a[@class = 'hrefch']")
    private List<ExtendedWebElement> productsTitles;

    @FindBy(xpath = "//div[div[@class = 'card h-100']/a][%d]")
    private ExtendedWebElement imageLink;

    @FindBy(xpath = "//div[div[@class = 'card h-100']/div/h4/a[@class = 'hrefch']][%d]//a[@class = 'hrefch']")
    private ExtendedWebElement productLinkByIndex;

    @FindBy(xpath = "//div[div[@class = 'card h-100']][%d]//h5")
    private ExtendedWebElement priceByIndex;

    @FindBy(xpath = "//div[div[@class = 'card h-100']//p[@id = 'article']][%d]//p[@id = 'article']")
    private ExtendedWebElement descriptionByIndex;


    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    public List<String> getProductsTitles() {
        List<String> titles = new ArrayList<>();
        for (ExtendedWebElement title : productsTitles) {
            titles.add(title.getText());
        }
        return titles;
    }
    public List<String> getTitles() {
        return productsTitles.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    public boolean isLoginLinkPresent() {
        return loginLink.isElementPresent();
    }
    public boolean isLoginLinkDisplayed() {
        return loginLink.isDisplayed();
    }
    public boolean isSignUpLinkPresent() {
        return signUpLink.isElementPresent();
    }
    public boolean isSignUpLinkDisplayed() {
        return signUpLink.isDisplayed();
    }
    public boolean isNameOfUserLinkPresent() {
        return nameOfUserLink.isElementPresent();
    }
    public boolean isNameOfUserLinkPresentWithText() {
        return nameOfUserLink.isElementWithTextPresent("Welcome " + R.TESTDATA.get("valid.username"));
    }
    public boolean isNameOfUserLinkDisplayed() {
        return nameOfUserLink.isDisplayed();
    }
    public boolean isLogoutLinkPresent() {
        return logoutLink.isElementPresent();
    }
    public boolean isLogoutLinkDisplayed() {
        return logoutLink.isDisplayed();
    }


    public LoginModal clickLoginLink() {
        loginLink.click();
        return loginModal;
    }
    public HomePage clickLogoutLink() {
        logoutLink.click();
        return this;
    }
    public ProductPage clickImageLink() {
        imageLink.click();
        return new ProductPage(getDriver());
    }
    public ProductPage clickOnProductLinkByIndex(int index) {
        productLinkByIndex.format(index).click();
        return new ProductPage(getDriver());
    }
    public Product getProductByIndex(int index) {
        Product product = new Product();
        product.setModel(productLinkByIndex.format(index).getText());
        product.setInformation(descriptionByIndex.format(index).getText());
        String cost = priceByIndex.format(index).getText().replace("$", "");
        product.setCost(Double.parseDouble(cost));
        return product;
    }
    @Override
    public void open() {
        super.openURL(Configuration.getRequired("home_url"));
    }
}
