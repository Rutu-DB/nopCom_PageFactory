package com.nopcommerce.demo.testSuite;

import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ComputerTest extends TestBase {
    HomePage homePage;
    ComputerPage computerPage;

    @BeforeMethod(groups = { "Smoke", "Regression"})
    public void setUp() {
        homePage = new HomePage();
        computerPage = new ComputerPage();
    }

    @Test(groups = {"Smoke", "Regression"})
    public void verifyUserShouldSuccessfullyNavigateToComputerPage() {

        computerPage.clickOnComputerLink();
        String actualResult = computerPage.actualMessageComputer();
        Assert.assertEquals(actualResult, "Computers");
    }

    @AfterMethod(groups = {"Smoke", "Regression"})
    public void tearDown() {
        driver.quit();

    }
}