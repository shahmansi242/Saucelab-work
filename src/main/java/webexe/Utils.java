package webexe;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage {
    //wait for click on element method
    public static void clickOnElement(By by) {

        driver.findElement(by).click();

    }
    //time stamp method
    public static String timeStamp() {
        return new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date());
        //  DateFormat dateFormat = new SimpleDateFormat("ddmmyyhhmmss");
        //  Date date = new Date();
        // return (dateFormat.format(date));

    }
    public static void assertURL(String text) {
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }
    public static void waitForClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void sendText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    public static void assertTextMessage(String message, String expected, By by) {
        String actual = getTextFromElement(by);
        Assert.assertEquals(message, expected, actual);
    }
    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }


}
