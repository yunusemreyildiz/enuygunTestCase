package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.time.Duration;

public class FlightPage extends TestBase {
    private static By fromInputSelector = By.xpath("//input[@data-testid='endesign-flight-origin-autosuggestion-input']");
    private static By toWhereInputId = By.xpath("//input[@data-testid='endesign-flight-destination-autosuggestion-input']");
    private static By searchButtonSelector = By.cssSelector("[data-testid='enuygun-homepage-flight-submitButton']");

    private static By twoWayOptionXpath = By.xpath("//*[@id=\"headlessui-tabs-panel-:ri:\"]/div/div/form/div[1]/div/div/div[1]/div[2]/label/div");

    private static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    public static void chooseTwoWayOption(){
        WebElement twoWayOptionElement = wait.until(ExpectedConditions.elementToBeClickable(twoWayOptionXpath));
        twoWayOptionElement.click();
        log.info("Clicked two way section..");
    }

    public static void inputFrom() throws InterruptedException {
        WebElement fromInputElement = wait.until(ExpectedConditions.elementToBeClickable(fromInputSelector));
        fromInputElement.click();
        Thread.sleep(4500);
        fromInputElement.sendKeys(Constants.FROM_CITY);
        Thread.sleep(4500);
        fromInputElement.sendKeys(Keys.ENTER);
        //selectFirstSuggestion();
        log.info("Entered Istanbul for the From section.");
    }

    public static void clickFlightSection(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("headlessui-tabs-tab-:rd:"))).click();
        log.info("Clicked Flight section");
    }

    public static void selectFirstSuggestion(){
        try {
            WebElement list = driver.findElement(By.xpath("//ul[@data-testid='endesign-flight-origin-autosuggestion-options']"));

            // Listenin ilk elemanını bul
            WebElement firstElement = list.findElement(By.xpath(".//li[@data-testid='endesign-flight-origin-autosuggestion-option-item-0']"));

            // İlk elemana tıkla
            firstElement.click();
        }catch (Exception e){

        }

    }

    public static void inputToWhere(){
        WebElement toWhereInputElement = wait.until(ExpectedConditions.elementToBeClickable(toWhereInputId));
        toWhereInputElement.click();
        toWhereInputElement.sendKeys(Constants.TO_WHERE_CITY);
        toWhereInputElement.sendKeys(Keys.ENTER);
        log.info("Entered Ankara for the From section.");
    }

    public static void clickSearch(){
        WebElement searchElement = wait.until(ExpectedConditions.elementToBeClickable(searchButtonSelector));
        searchElement.click();
        log.info("Clicked button for see results.");
    }


    public static void setSliderValue(WebElement slider, int startHour, int endHour) {
        // JavaScriptExecutor'ı kullanarak slider'ı ayarla
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int sliderWidth = slider.getSize().getWidth();

        // Başlangıç saatini ayarla
        int startX = (int) ((startHour / 24.0) * sliderWidth);
        js.executeScript("arguments[0].setAttribute('style', 'left: " + startX + "px;')", slider);

        // Bitiş saatini ayarla
        int endX = (int) ((endHour / 24.0) * sliderWidth);
        js.executeScript("arguments[0].setAttribute('style', 'left: " + endX + "px;')", slider);
    }
}
