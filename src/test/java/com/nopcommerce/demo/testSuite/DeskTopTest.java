package com.nopcommerce.demo.testSuite;

import com.nopcommerce.demo.pages.DesktopPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeskTopTest extends TestBase {
    HomePage homePage;
    DesktopPage desktopPage;

    @BeforeMethod(groups = {"Sanity", "Regression"})
    public void setUp() {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
    }

    @Test(groups = {"Sanity", "Regression"})
    public void verifyUserIsOnDesktopPage() throws InterruptedException {
        desktopPage.clickOnComputerLink();
        desktopPage.clickDesktopLink();
        desktopPage.sortProductsOrderByZToA();
        desktopPage.deskTopPageAction();
        desktopPage.clickonAddToCartBtn();
        String actualResult = desktopPage.actualMessageBuildYourOwnDesktop();
        Assert.assertEquals(actualResult, "Build your own computer");
    }
    @AfterMethod(groups = {"Sanity","Regression"})
    public void tearDown() {
        driver.quit();

    }

}
