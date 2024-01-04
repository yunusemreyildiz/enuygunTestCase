package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import utils.Constants;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SearchResultsPage extends TestBase {
    private static WebElement sliderFilter = driver.findElement(By.xpath("//*[@id=\"SearchRoot\"]/div[2]/div[1]/div[3]/div[4]/div[1]"));
    public static WebElement firstSliderLeft = driver.findElement(By.xpath("//*[@id=\"SearchRoot\"]/div[2]/div[1]/div[3]/div[4]/div[2]/div/div[1]/div[2]/div/div[4]"));
    public static WebElement firstSliderRight = driver.findElement(By.xpath("//*[@id=\"SearchRoot\"]/div[2]/div[1]/div[3]/div[4]/div[2]/div/div[1]/div[2]/div/div[5]"));
    public static WebElement secondSliderLeft = driver.findElement(By.xpath("//*[@id=\"SearchRoot\"]/div[2]/div[1]/div[3]/div[4]/div[2]/div/div[2]/div[2]/div/div[4]"));
    public static WebElement secondSliderRight = driver.findElement(By.xpath("//*[@id=\"SearchRoot\"]/div[2]/div[1]/div[3]/div[4]/div[2]/div/div[2]/div[2]/div/div[5]"));
    public static WebElement openAirlineBrandFilter = driver.findElement(By.xpath("//*[@id=\"SearchRoot\"]/div[2]/div[1]/div[3]/div[6]/div[1]"));
    public static WebElement turkishAirlinesFilter = driver.findElement(By.id("TKairlines"));


    private static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


    public static void setTakeOffTime() throws InterruptedException {
        sliderFilter.click();

        setSliderPosition(firstSliderLeft, Constants.PERCENTAGE_FOR_TEN_OCLOCK); // İlk slider'ı %30 konumuna getirir
        releaseSlider(firstSliderLeft);
        Thread.sleep(2000);
        setSliderPosition(firstSliderRight, Constants.PERCENTAGE_FOR_EIGHTEEN_OCLOCK); // İlk slider'ı %30 konumuna getirir
        releaseSlider(firstSliderRight);

    }

    public static void releaseSlider(WebElement slider) {
        Actions actions = new Actions(driver);
        actions.release(slider).perform();
    }


    public static void setSliderPosition(WebElement slider, double percentage) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "arguments[0].style.left = '" + percentage + "%';";
        js.executeScript(script, slider);
    }


    public static void setLandingTime() throws InterruptedException {
        setSliderPosition(secondSliderLeft, Constants.PERCENTAGE_FOR_TEN_OCLOCK);
        releaseSlider(secondSliderLeft);
        Thread.sleep(2000);
        setSliderPosition(secondSliderRight, Constants.PERCENTAGE_FOR_EIGHTEEN_OCLOCK);
        releaseSlider(secondSliderRight);

    }


    public static void checkTheResult() {
        WebElement filterSlider = driver.findElement(By.className("filter-slider-content"));
        String filterText = filterSlider.getText().trim();
        System.out.println(filterText);

        if (isTimeRangeValid(filterText)) {
            System.out.println("Uçuş saat aralığı 10:00 ile 18:00 arasında.");
        } else {
            System.out.println("Uçuş saat aralığı 10:00 ile 18:00 arasında değil.");
        }
    }

    private static boolean isTimeRangeValid(String filterText) {
        return filterText.equals("10:00 ile 18:00 arası");
    }

    public static void applyTurkishAirlinesFilter() throws InterruptedException {
        openAirlineBrandFilter.click();
        turkishAirlinesFilter.click();
        Thread.sleep(4500);
    }

    public static void checkFlightPrices() {
        List<WebElement> priceElements = driver.findElements(By.xpath("//div[@class='flight-price']"));
        List<Double> prices = new ArrayList<>();

        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replaceAll("[^\\d.]", "");
            double price = Double.parseDouble(priceText);
            prices.add(price);
        }

        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);

        if (prices.equals(sortedPrices)) {
            System.out.println("Uçuş fiyatları artan sırayla listelenmiştir.");
        } else {
            System.out.println("Uçuş fiyatları artan sırayla listelenmemiştir.");
        }
    }

}
