package com.nopcommerce.demo.testSuite;

import com.nopcommerce.demo.pages.BuildYourComputerPage;
import com.nopcommerce.demo.pages.DesktopPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.ShoppingCartPage;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingCartTest extends TestBase {
    HomePage homepage;
    DesktopPage desktopPage;
    BuildYourComputerPage buildYourComputerPage;
    ShoppingCartPage shoppingCartPage;


    @BeforeMethod(groups = {"Regression"})
    public void setUp() {
        homepage = new HomePage();
        desktopPage = new DesktopPage();
        shoppingCartPage = new ShoppingCartPage();
        buildYourComputerPage = new BuildYourComputerPage();
    }

    @Test(groups = {"Regression"})
    public void verifyUserCanSuccessfullyAddProductToShoppingCart() throws InterruptedException {

        desktopPage.clickOnComputerLink();
        desktopPage.clickDesktopLink();
        desktopPage.deskTopPageAction();
        desktopPage.clickonAddToCartBtn();

        buildYourComputerPage = new BuildYourComputerPage();
        buildYourComputerPage.buildYourOwnComputerSelectProcessor();
        buildYourComputerPage.buildYourOwnComputerSelectRAM();
        buildYourComputerPage.buildYourOwnComputerRadioButton();
        buildYourComputerPage.buildYourOwnComputerCheckBox();
        String actualResult = buildYourComputerPage.actualAmountMessage();
        Assert.assertEquals(actualResult, "$1,475.00");
        buildYourComputerPage.buildYourOwnComputerAddToCartBtn();
        buildYourComputerPage.notificationDisplay();

        shoppingCartPage.moveToShoppingCart();
        shoppingCartPage.amendQtyField();
        shoppingCartPage.updateFinalCart();

    }

    @AfterMethod(groups = {"Sanity","Regression"})
    public void tearDown() {
        driver.quit();

    }


}
