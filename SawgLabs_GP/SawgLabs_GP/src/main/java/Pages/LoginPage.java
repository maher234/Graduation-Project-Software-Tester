package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //<----------------------------------------------Locators---------------------------------------------->
    By username = By.id("user-name");
    By password = By.name("password");
    By loginBtn = By.xpath("//input[@class='submit-button btn_action']");
    By errorMsg = By.cssSelector("[data-test='error']");
    By productsTitle = By.xpath("//span[text()='Products']");
    By logo = By.className("app_logo");

    //<----------------------------------------------Actions---------------------------------------------->
    public void enterUsername(String user)
    {
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass)
    {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin()
    {
        driver.findElement(loginBtn).click();
    }

    public void login(String user, String pass)
    {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    public boolean isErrorDisplayed()
    {
        return driver.findElement(errorMsg).isDisplayed();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }

    public boolean isProductsDisplayed()
    {
        return driver.findElement(productsTitle).isDisplayed();
    }

    public String getLogoText()
    {
        return driver.findElement(logo).getText();
    }

}