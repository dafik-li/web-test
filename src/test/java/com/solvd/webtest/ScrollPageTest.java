package com.solvd.webtest;

import com.solvd.webtest.page.HomePage;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ScrollPageTest extends AbstractTest {

    @Test(description = "verify scroll page")
    public void verifyScrollPage() throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        sa.assertTrue(homePage.isPageOpened(), "page is not opened");

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(1L)).until(dev -> js.executeScript("window.scrollTo(0, -document.body.scrollHeight)"));
        //wait(1000);
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }
}
