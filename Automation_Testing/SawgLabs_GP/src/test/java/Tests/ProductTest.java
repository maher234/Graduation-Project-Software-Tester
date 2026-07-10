package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test
    public void openProductDetails()
    {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        homePage.clickFirstProduct();

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory-item"));
    }

    @Test
    public void verifyProductName()
    {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        homePage.clickFirstProduct();

        Assert.assertEquals(
                productPage.getProductName(),
                "Sauce Labs Backpack");
    }

    @Test
    public void verifyProductPrice()
    {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        homePage.clickFirstProduct();

        Assert.assertEquals(
                productPage.getProductPrice(),
                "$29.99");
    }

    @Test
    public void addProductToCart()
    {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        homePage.clickFirstProduct();

        productPage.clickAddToCart();

        Assert.assertTrue(productPage.isRemoveButtonDisplayed());
    }

    @Test
    public void backToProducts()
    {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        homePage.clickFirstProduct();

        productPage.clickBackToProducts();

        Assert.assertTrue(homePage.isProductsTitleDisplayed());
    }

}