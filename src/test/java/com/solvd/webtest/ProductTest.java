package com.solvd.webtest;

import com.solvd.webtest.components.ProductCard;
import com.solvd.webtest.page.HomePage;
import com.solvd.webtest.page.ProductPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductTest extends AbstractTest {

    @Test(description = "verify equals product on homepage and product on its page")
    public void verifyProductCard() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        sa.assertTrue(homePage.isPageOpened(), "page is not opened");

        ProductCard productCard = homePage.getProductCard();
        ProductPage productPage = productCard.getProductBlock().clickTitleLink();
        sa.assertTrue(productPage.isPageOpened());

        sa.assertAll();
    }
}
