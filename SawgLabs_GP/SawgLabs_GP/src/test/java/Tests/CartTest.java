package Tests;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void addProductToCart()
    {
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        cartPage.clickAddToCart();

        Assert.assertEquals(cartPage.getCartBadge(), "1");
    }

    @Test
    public void verifyProductInCart()
    {
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        cartPage.clickAddToCart();
        cartPage.clickCart();

        Assert.assertEquals(cartPage.getCartTitle(), "Your Cart");
        Assert.assertEquals(cartPage.getProductName(), "Sauce Labs Backpack");
    }

    @Test
    public void removeProductFromCart()
    {
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        cartPage.clickAddToCart();
        cartPage.clickCart();
        cartPage.clickRemove();

        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
    }

    @Test
    public void continueShopping()
    {
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("standard_user", "secret_sauce");

        cartPage.clickAddToCart();
        cartPage.clickCart();
        cartPage.clickContinueShopping();

        Assert.assertTrue(homePage.isProductsTitleDisplayed());
    }

    @Test
    public void verifyCartIconCount()
    {
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        cartPage.clickAddToCart();

        Assert.assertEquals(cartPage.getCartBadge(), "1");
    }
}