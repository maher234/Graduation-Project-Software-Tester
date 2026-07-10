package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Screenshot {

    public static String takeScreenshot(WebDriver driver, String screenshotName) {

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String screenshotPath = System.getProperty("user.dir")
                + "/screenshots/" + screenshotName + "_" + timestamp + ".png";

        try {

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(screenshotPath);

            //automatically create the screenshots folder the first time a screenshot is taken.
            File folder = new File(System.getProperty("user.dir") + "/screenshots");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            FileUtils.copyFile(src, dest);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}