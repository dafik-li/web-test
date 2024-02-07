package com.solvd.webtest.page;

import com.solvd.webtest.components.LoginModal;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//a[@id = 'login2']")
    ExtendedWebElement loginLink;

    @FindBy(xpath = "//div[@id = 'logInModal']")
    private LoginModal loginModal;



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

    @Override
    public void openURL(String url) {
        super.openURL(Configuration.getRequired("home_url"));
    }
}
