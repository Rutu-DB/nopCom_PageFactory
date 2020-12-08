package com.nopcommerce.demo.testSuite;

import com.nopcommerce.demo.pages.BuildYourComputerPage;
import com.nopcommerce.demo.pages.DesktopPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BuildYourOwnComputerTest extends TestBase {
    HomePage homePage;
    DesktopPage desktopPage;
    BuildYourComputerPage buildYourComputerPage;

    @BeforeMethod(groups = {"Regression"})
    public void setUp() {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
    }



    @Test(groups = {"Regression"})
    public void verifyUserCanBuildYourOwnComputerPage() throws InterruptedException {
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

    }

    @AfterMethod(groups = {"Regression"})
    public void tearDown() {
        driver.quit();

    }
}