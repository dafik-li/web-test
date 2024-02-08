package com.solvd.webtest;

import com.solvd.webtest.domain.Product;
import com.solvd.webtest.page.HomePage;
import com.solvd.webtest.page.ProductPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductTest extends AbstractTest {

    @Test(description = "verify equals product on homepage and product on its page")
    public void verifyProductCardTest() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        sa.assertTrue(homePage.isPageOpened(), "page is not opened");

        ProductPage productPage = homePage.headlineLinkByIndex(1);
        sa.assertTrue(productPage.isPageOpened(), "product page is not opened");

        Product productFromHomePage = homePage.getProductByIndex(1);
        Product productFromProductPage = productPage.getProduct();
        sa.assertEquals(productFromProductPage, productFromHomePage);

        sa.assertAll();
    }
}
