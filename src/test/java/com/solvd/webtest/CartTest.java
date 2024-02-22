package com.solvd.webtest;

import com.solvd.webtest.domain.Product;
import com.solvd.webtest.page.CartPage;
import com.solvd.webtest.page.HomePage;
import com.solvd.webtest.page.ProductPage;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.List;

public class CartTest extends AbstractTest {

    @Test(description = "verify to add/delete product to cart")
    public void verifyCartTest() {
        WebDriver driver = getDriver();
        SoftAssert sa = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        sa.assertTrue(homePage.isPageOpened(), "homepage is not opened");

        ProductPage firstProductPage = homePage.clickOnProductLinkByIndex(1);
        sa.assertTrue(firstProductPage.isPageOpened(), "product page is not opened");
        Product firstProduct = firstProductPage.clickOnAddToCartButton();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(100))
                .until(d-> firstProductPage.isAlertPresent());
        driver.switchTo().alert().accept();

        //driver.navigate().back();
        firstProductPage.clickOnToHomePageLink();

        sa.assertTrue(homePage.isPageOpened(), "homepage is not opened");
        ProductPage secondProductPage = homePage.clickOnProductLinkByIndex(2);
        sa.assertTrue(secondProductPage.isPageOpened(), "product page is not opened");
        Product secondProduct = secondProductPage.clickOnAddToCartButton();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(100))
                .until(d-> secondProductPage.isAlertPresent());
        driver.switchTo().alert().accept();

        CartPage cartPage = secondProductPage.clickOnCartLink();
        sa.assertTrue(cartPage.isPageOpened(), "cart page is not opened");
        List<String> productNumbers = cartPage.getProductsFromCart();
        sa.assertTrue(productNumbers.size() == 2, "not 2 products in cart");
        sa.assertEquals(productNumbers.get(0), firstProduct, "products in cart are not equals");
        sa.assertEquals(productNumbers.get(1), secondProduct, "products in cart are not equals");
        String totalSum = String.valueOf(firstProduct.getCost() + secondProduct.getCost());
        sa.assertEquals(cartPage.getTotalSum().getText(), totalSum, "total sum is not equals to sum of the products");

        String deletedProduct = cartPage.clickOnDeleteProductByIndexLink(1);
        sa.assertTrue(productNumbers.size() == 1, String.format("%s has not been deleted", deletedProduct));
        sa.assertEquals(deletedProduct, productNumbers.get(0), "was deleted wrong product");
        sa.assertEquals(cartPage.getTotalSum().getText(), totalSum, "total sum is not equals to sum of the products");

        sa.assertAll();
    }
}
