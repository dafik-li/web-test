package com.solvd.webtest.page;

import com.solvd.webtest.components.ProductCard;
import com.solvd.webtest.components.LoginModal;
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

    @FindBy(xpath = "//div[@class = 'card h-100']")
    private ProductCard productCard;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    public ExtendedWebElement getLoginLink() {
        return loginLink;
    }
    public LoginModal getLoginModal() {
        return loginModal;
    }
    public ExtendedWebElement getSignUpLink() {
        return signUpLink;
    }
    public ExtendedWebElement getNameOfUserLink() {
        return nameOfUserLink;
    }
    public ExtendedWebElement getLogoutLink() {
        return logoutLink;
    }
    public ProductCard getProductCard() {
        return productCard;
    }

    public LoginModal clickLoginLink() {
        getLoginLink().click();
        return getLoginModal();
    }
    public HomePage clickLogoutLink() {
        getLogoutLink().click();
        return new HomePage(driver);
    }
    @Override
    public void open() {
       super.openURL(Configuration.getRequired("home_url"));
    }
}
