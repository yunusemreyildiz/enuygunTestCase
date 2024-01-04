package tests;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import pages.FlightPage;
import pages.SearchResultsPage;
import utils.Constants;

public class PriceSortingForFlightTest extends TestBase {
    private static Logger log  = Logger.getLogger(TimeFilterControlForFlightTest.class);

    @Before
    public void setup(){
        setDriver();
        PropertyConfigurator.configure(Constants.LOG4J_PROPERTIES_FILE_PATH);
    }

    @After
    public void teardown(){
        closeDriver();
        log.info("Chromedriver has been finished, test is over.");
    }

    @Given("Navigate to the website")
    public void navigate_to_website() {
        navigateToHome();
    }

    @When("Check the homepage loading")
    public void check_home_page_is_loaded() {
        isPageLoaded();
    }
    @When("Click flight from top menu")
    public void get_cursor_to_the_category() {
        FlightPage.clickFlightSection();
    }
    @And("Choose two way with radio button")
    public void click_option_from_hamburger_menu() {
        FlightPage.chooseTwoWayOption();
    }

    @And("Select take off city")
    public void select_city() throws InterruptedException {
        FlightPage.inputFrom();
    }
    @And("Select landing city")
    public void select_destination_city() {
        FlightPage.inputToWhere();
    }
    @And("Click the search button")
    public void click_search_button() {
        FlightPage.clickSearch();
    }
    @When("From results page, select take-off time from slider")
    public void arrange_first_slider() throws InterruptedException {
        SearchResultsPage.setTakeOffTime();
    }

    @When("From results page, select landing time from the second slider")
    public void arrange_second_slider() throws InterruptedException {
        SearchResultsPage.setLandingTime();
    }
    @And("Select the Turk Hava Yollari from filter")
    public void check_thy_from_filters() throws InterruptedException {
        SearchResultsPage.applyTurkishAirlinesFilter();
    }

    @Then("Check the price sorting")
    public void check_the_price_sorting() throws InterruptedException {
        SearchResultsPage.checkFlightPrices();
    }



}
