package Tests;

import Utils.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;


import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;


    @BeforeMethod
    public void setUp(@Optional("chrome") String browser , @Optional("true")String headless)
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
    }



    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException {

        if (result.getStatus() == ITestResult.FAILURE) {
            Screenshot.takeScreenshot(driver, result.getName());
        }

        Thread.sleep(3000);
        driver.quit();
    }
   
}