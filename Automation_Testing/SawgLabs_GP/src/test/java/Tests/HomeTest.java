package Tests;

import Pages.LoginPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test
    public void validateHomePageAfterLogin()
    {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(homePage.isProductsTitleDisplayed());  //Swag Labs
        Assert.assertEquals(homePage.getLogoText(), "Wrong Logo");
    }

    @Test
    public void validateFirstProductName()
    {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertFalse(homePage.getFirstProductName().isEmpty());
    }

    @Test
    public void validateFirstProductPrice()
    {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertFalse(homePage.getFirstProductPrice().isEmpty());
    }

    @Test
    public void validateFirstProductNameText()
    {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertEquals(
                homePage.getFirstProductName(),
                "Sauce Labs Backpack");
    }

    @Test
    public void validateOpenFirstProduct()
    {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("standard_user", "secret_sauce");

        homePage.clickFirstProduct();

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory-item"));
    }



}