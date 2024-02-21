package com.solvd.webtest.page;

import com.solvd.webtest.components.login.LoginModal;
import com.solvd.webtest.domain.Product;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//nav[@id = 'narvbarx']//div[@id = 'navbarExample']//ul//li//a[@id = 'login2']")
    private ExtendedWebElement loginLink;

    @FindBy(xpath = "//div[@id = 'logInModal']")
    private LoginModal loginModal;

    @FindBy(xpath = "//nav[@id = 'narvbarx']//div[@id = 'navbarExample']//ul//li//a[@id = 'signin2']")
    private ExtendedWebElement signUpLink;

    @FindBy(xpath = "//nav[@id = 'narvbarx']//div[@id = 'navbarExample']//ul//li//a[@id = 'nameofuser']")
    private ExtendedWebElement nameOfUserLink;

    @FindBy(xpath = "//nav[@id = 'narvbarx']//div[@id = 'navbarExample']//ul//li//a[@id = 'logout2']")
    private ExtendedWebElement logoutLink;
    //div[@id= 'tbodyid']//a[@href= 'prod.html?idp_=1']//img[@src = 'imgs/galaxy_s6.jpg']
    @FindBy(xpath = "//div[@id= 'tbodyid']//a[%d]//img[%d]")
    private ExtendedWebElement imageLink;

    @FindBy(xpath = "//h4[@class = 'card-title'][%d]")
    private ExtendedWebElement headlineLinkByIndex;

    @FindBy(xpath = "//div[@id= 'tbodyid']//div[@class = 'card-block']//h5[%d]")
    private ExtendedWebElement priceByIndex;

    @FindBy(xpath = "//div[@id= 'tbodyid']//div[@class = 'card-block']//p[@id = 'article'][%d]")
    private ExtendedWebElement descriptionByIndex;


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
    public ExtendedWebElement getImageLink() {
        return imageLink;
    }
    public ExtendedWebElement getHeadlineLinkByIndex() {
        return headlineLinkByIndex;
    }
    public ExtendedWebElement getPriceByIndex() {
        return priceByIndex;
    }
    public ExtendedWebElement getDescriptionByIndex() {
        return descriptionByIndex;
    }
    public LoginModal clickLoginLink() {
        getLoginLink().click();
        return getLoginModal();
    }
    public HomePage clickLogoutLink() {
        getLogoutLink().click();
        return new HomePage(driver);
    }
    public ProductPage clickImageLink() {
        getImageLink().click();
        return new ProductPage(getDriver());
    }
    public ProductPage headlineLinkByIndex(int index) {
        getHeadlineLinkByIndex().format(index).click();
        return new ProductPage(getDriver());
    }
    public Product getProductByIndex(int index) {
        Product product = new Product();
        product.setModel(getHeadlineLinkByIndex().format(index).getText());
        product.setInformation(getDescriptionByIndex().format(index).getText());
        String cost = getPriceByIndex().format(index).getText().replace("$", "");
        product.setCost(Double.parseDouble(cost));
        return product;
    }
    @Override
    public void open() {
        super.openURL(Configuration.getRequired("home_url"));
    }
}
