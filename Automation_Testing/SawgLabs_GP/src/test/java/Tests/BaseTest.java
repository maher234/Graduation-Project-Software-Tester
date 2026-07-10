package Tests;

import Utils.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import java.time.Duration;

import org.openqa.selenium.edge.EdgeOptions;

public class BaseTest {

    protected WebDriver driver;


    @BeforeMethod
    public void setUp(@Optional("chrome") String browser,
                      @Optional("true") String headless)
    {
        EdgeOptions options = new EdgeOptions();

        options.addArguments("--no-sandbox"); 
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        driver = new EdgeDriver(options);

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
}
