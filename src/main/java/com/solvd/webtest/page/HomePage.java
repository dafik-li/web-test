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

    @FindBy(xpath = "//div[@class = 'card h-100']/a")
    private ExtendedWebElement imageLink;

    @FindBy(xpath = "//div[div[@class = 'card h-100']/div[@class = 'card-block']/h4/a[@class = 'hrefch']][%d]")
    private ExtendedWebElement headlineLinkByIndex;

    @FindBy(xpath = "//div/div[@class = 'card h-100']/div[@class = 'card-block']/h5")
    private ExtendedWebElement priceByIndex;

    @FindBy(xpath = "//div[div[@class = 'card h-100']/div[@class = 'card-block']/p[@id = 'article']][%d]")
    private ExtendedWebElement descriptionByIndex;


    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
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
        loginLink.click();
        return new HomePage(driver);
    }
    public ProductPage clickImageLink() {
        imageLink.click();
        return new ProductPage(getDriver());
    }
    public ProductPage clickOnProductLinkByIndex(int index) {
        headlineLinkByIndex.format(index).click();
        return new ProductPage(getDriver());
    }
    public Product getProductByIndex(int index) {
        Product product = new Product();
        product.setModel(headlineLinkByIndex.format(index).getText());
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
