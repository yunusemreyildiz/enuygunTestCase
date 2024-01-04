package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class TestBase {

    public static WebDriver driver;
    public static Logger log  = Logger.getLogger(TestBase.class);


    public static void setDriver(){
        System.setProperty("webdriver.chrome.driver","/Users/yunusemreyildiz/Downloads/enuygunTestCase/src/test/java/drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
         driver = new ChromeDriver(chromeOptions);
    }

    public static void navigateToHome(){
        driver.get(Constants.BASE_URL);
        log.info("Home page opened.");
        driver.manage().window().maximize();
        log.info("Chrome window maximized..");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public static void isPageLoaded(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(webDriver ->
                (js).executeScript("return document.readyState;").equals("complete"));
        log.info("Page loaded successfully.");
    }


    public static void closeDriver(){
        driver.quit();
    }


}
