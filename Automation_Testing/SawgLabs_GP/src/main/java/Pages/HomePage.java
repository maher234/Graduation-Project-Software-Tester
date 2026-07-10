package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    //<----------------------------------------------Locators---------------------------------------------->
    By productsTitle = By.xpath("//span[text()='Products']");
    By logo = By.className("app_logo");

    By firstProduct = By.id("item_4_title_link");
    By firstProductName = By.className("inventory_item_name");
    By firstProductPrice = By.xpath("(//div[@class='inventory_item_price'])[1]");
    //<-----------------------------------------Actions/Validations---------------------------------------->
    public boolean isProductsTitleDisplayed()
    {
        return driver.findElement(productsTitle).isDisplayed();
    }

    public String getLogoText()
    {
        return driver.findElement(logo).getText();
    }

    public String getFirstProductName()
    {
        return driver.findElement(firstProductName).getText();
    }

    public String getFirstProductPrice()
    {
        return driver.findElement(firstProductPrice).getText();
    }

    public void clickFirstProduct()
    {
        driver.findElement(firstProduct).click();
    }
}