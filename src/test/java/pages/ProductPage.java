package pages;

import base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;


import java.time.Duration;

public class ProductPage extends TestBase {

    public static void checkTheProductPageLoad(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        AssertJUnit.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product-main-container > div.product > div > div.product-card > div > div > div.col-12.col-md-4.col-lg-3.pr-md-0.product-card__right > div > div.product-card__content.product-card__section > div > div.product-card__details__left > h1"))).getText(),"Regular Fit Suni Deri Blazer Ceket");
        log.info(driver.findElement(By.cssSelector("#product-main-container > div.product > div > div.product-card > div > div > div.col-12.col-md-4.col-lg-3.pr-md-0.product-card__right > div > div.product-card__content.product-card__section > div > div.product-card__details__left > h1")).getText() + " product loaded succesfully.");
    }

    public static void sizeSelection(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"product-main-container\"]/div[1]/div/div[1]/div/div/div[3]/div/div[3]/div[3]/button[1]"))).click();
        log.info("Size selected.");
    }

    public static void addToBasket(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product-main-container > div.product > div > div.product-card > div > div > div.col-12.col-md-4.col-lg-3.pr-md-0.product-card__right > div > div.product-card__action > button > span.action-btn-text1.active"))).click();
        log.info("Product added to basket.");
    }

}
