package com.solvd.webtest;

import com.solvd.webtest.domain.Product;
import com.solvd.webtest.page.CartPage;
import com.solvd.webtest.page.HomePage;
import com.solvd.webtest.page.ProductPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CartTest extends AbstractTest {

    @Test(description = "verify to add/delete product to cart")
    public void verifyCartTest() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        sa.assertTrue(homePage.isPageOpened(), "homepage is not opened");

        ProductPage firstProductPage = homePage.headlineLinkByIndex(1);
        sa.assertTrue(firstProductPage.isPageOpened(), "product page is not opened");
        Product firstProduct = firstProductPage.clickOnAddToCartButton();

        firstProductPage.clickOnToHomePageLink();

        sa.assertTrue(homePage.isPageOpened(), "homepage is not opened");
        ProductPage secondProductPage = homePage.headlineLinkByIndex(1);
        sa.assertTrue(secondProductPage.isPageOpened(), "product page is not opened");
        Product secondProduct = secondProductPage.clickOnAddToCartButton();

        CartPage cartPage = secondProductPage.clickOnCartLink();
        sa.assertTrue(cartPage.isPageOpened(), "cart page is not opened");
        List<String> productNumbers = cartPage.getProductsFromCart();
        sa.assertTrue(productNumbers.size() == 2, "not 2 products in cart");
        sa.assertEquals(productNumbers.get(0), firstProduct, "products in cart are not equals");
        sa.assertEquals(productNumbers.get(1), secondProduct, "products in cart are not equals");

        sa.assertAll();
    }
}
