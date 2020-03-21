package webexe;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserSelector extends Utils {
    // created object for LoadProp class
    public static LoadProp loadProp = new LoadProp();
    // getting username from data file for SauceLab account
    public static final String USERNAME = loadProp.getProperty( "SAUCE_USERNAME" );
    // get access key for SauceLab from datafile using loadprop
    public static String ACCESS_KEY = loadProp.getProperty( "SAUCE_ACCESS_KEY" );
    // url for SauceLab account for access
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com/wd/hub";
    // boolean condition for SauceLab or local
    public static final boolean SAUCE_LAB = Boolean.parseBoolean( System.getProperty( "Sauce" ) );
    // get browser name from data file
    public static final String browser = System.getProperty( "browser" );

    // browser set up method
    public void setUpBrowser()
    // if SauceLab true
    {   if (SAUCE_LAB)
    {
        // message  if test is running on SauceLab
        System.out.println( "Running in SauceLab...........With Browser " + browser );
        // If Browser is chrome, properties for chrome browser and platform
        if (browser.equalsIgnoreCase( "chrome" ))
        {
            DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setCapability( "platform", "Windows 8" );
            caps.setCapability( "version", "78.0" );
            try
            {
                driver = new RemoteWebDriver( new URL( URL ), caps );
                driver.manage().timeouts().implicitlyWait( 20, TimeUnit.SECONDS );
                // get application url from data file
                driver.get( loadProp.getProperty( "url" ) );
            } catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
        }
        // properties for firefox browser and windows platform
        else if (browser.equalsIgnoreCase( "firefox" ))
        {
            DesiredCapabilities caps = DesiredCapabilities.firefox();
            caps.setCapability( "platform", "Windows 7" );
            caps.setCapability( "version", "56" );
            caps.setCapability( "name", "Testing on Firefox 56" );
            try
            {
                driver = new RemoteWebDriver( new URL( URL ), caps );
                driver.manage().timeouts().implicitlyWait( 20, TimeUnit.SECONDS );
                driver.get( loadProp.getProperty( "url" ) );
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if (browser.equalsIgnoreCase( "IE" ))
        {
            DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
            caps.setCapability( "platform", "Windows 10" );
            caps.setCapability( "version", "11" );
            try
            {
                driver = new RemoteWebDriver( new URL( URL ), caps );
                driver.manage().timeouts().implicitlyWait( 20, TimeUnit.SECONDS );
                driver.get( loadProp.getProperty( "url" ) );
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if (browser.equalsIgnoreCase( "safari" ))
        {
            DesiredCapabilities caps = DesiredCapabilities.safari();
            caps.setCapability( "platform", "OS X10.10" );
            caps.setCapability( "version", "8.0" );
            try
            {
                driver = new RemoteWebDriver( new URL( URL ), caps );
                driver.manage().timeouts().implicitlyWait( 20, TimeUnit.SECONDS );
                driver.get( loadProp.getProperty( "url" ) );
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        } else
        {
            System.out.println( "Wrong browserName or empty: " + browser );
        }
    }
        // if sauce lab is false
        else {

            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/Resourses/BrowserDriver/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().fullscreen();
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                driver.get("https://demo.nopcommerce.com/");
                // user select firefox browser
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/test/Resourses/BrowserDriver/geckodriver.exe");

                driver = new FirefoxDriver();
                driver.manage().window().fullscreen();
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                driver.get("https://demo.nopcommerce.com/");
                // user select Microsoft Edge browser
            } else if (browser.equalsIgnoreCase("Microsoft Edge")) {
                System.setProperty("webdriver.edge.driver", "src/test/Resourses/BrowserDriver/IEDriverServer.exe");
                driver = new EdgeDriver();
                driver.manage().window().fullscreen();
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                driver.get("https://demo.nopcommerce.com/");
            } else {
                System.out.println("Browser is not correct" + browser);
            }
        }
    }

    public void closeBrowser() {
        driver.quit();
    }


}





