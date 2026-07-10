package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //<----------------------------------------------Locators---------------------------------------------->

    By productName = By.className("inventory_details_name");
    By productPrice = By.className("inventory_details_price");
    By addToCartBtn = By.id("add-to-cart");
    By removeBtn = By.id("remove");
    By backBtn = By.id("back-to-products");

    //<-----------------------------------------Actions---------------------------------------->

    public String getProductName()
    {
        return driver.findElement(productName).getText();
    }

    public String getProductPrice()
    {
        return driver.findElement(productPrice).getText();
    }

    public void clickAddToCart()
    {
        driver.findElement(addToCartBtn).click();
    }

    public boolean isRemoveButtonDisplayed()
    {
        return driver.findElement(removeBtn).isDisplayed();
    }

    public void clickBackToProducts()
    {
        driver.findElement(backBtn).click();
    }

}