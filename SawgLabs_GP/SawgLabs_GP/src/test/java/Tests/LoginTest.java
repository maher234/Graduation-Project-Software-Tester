package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validateValidLogin()
    {
        // TC01 - Valid Login
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("standard_user", "secret_sauce");

//        Assert.assertTrue(loginPage.isProductsDisplayed());
//        Assert.assertEquals(loginPage.getLogoText(), "Swag Labs");

    }

    @Test
    public void loginWithInvalidUsername()
    {
        // TC02 - Login with invalid username
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("invalid","secret_sauce");
            Assert.assertEquals(driver.getCurrentUrl() , "https://www.saucedemo.com/");
            Assert.assertTrue(loginPage.isErrorDisplayed());

    }

    @Test
    public void loginWithInvalidPassword()
    {
        // TC03 - Invalid password
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user","invalid");

         Assert.assertTrue(loginPage.isErrorDisplayed());

    }

    @Test
    public void loginWithEmptyUsername() {
        // TC04 - Login with empty username
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("", "secret_sauce");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }

    @Test
    public void loginWithEmptyPassword() {
        // TC05 - Login with empty password
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }



}
