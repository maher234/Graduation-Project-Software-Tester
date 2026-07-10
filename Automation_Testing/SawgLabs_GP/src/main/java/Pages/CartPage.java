package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //<----------------------------------------------Locators---------------------------------------------->

    By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");
    By cartBadge = By.className("shopping_cart_badge");
    By cartTitle = By.className("title");
    By productName = By.className("inventory_item_name");
    By removeBtn = By.id("remove-sauce-labs-backpack");
    By continueShoppingBtn = By.id("continue-shopping");

    //<----------------------------------------------Actions---------------------------------------------->

    public void clickAddToCart()
    {
        driver.findElement(addToCartBtn).click();
    }

    public void clickCart()
    {
        driver.findElement(cartIcon).click();
    }

    public void clickRemove()
    {
        driver.findElement(removeBtn).click();
    }

    public void clickContinueShopping()
    {
        driver.findElement(continueShoppingBtn).click();
    }

    //<-------------------------------------------Validations--------------------------------------------->

    public String getCartBadge()
    {
        return driver.findElement(cartBadge).getText();
    }

    public String getCartTitle()
    {
        return driver.findElement(cartTitle).getText();
    }

    public String getProductName()
    {
        return driver.findElement(productName).getText();
    }

    public boolean isProductDisplayed()
    {
        return driver.findElement(productName).isDisplayed();
    }
}