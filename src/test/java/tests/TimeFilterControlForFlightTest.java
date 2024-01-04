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
import pages.*;
import utils.Constants;

public class TimeFilterControlForFlightTest extends TestBase {
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

    @Given("Navigate to website")
    public void navigate_to_the_website() {
        navigateToHome();
    }

    @When("Check home page is loaded")
    public void check_home_page_is_loaded() {
        isPageLoaded();
    }
    @When("Click flight from the top menu")
    public void click_flight_option() {
        FlightPage.clickFlightSection();
    }
    @And("Choose the two way option from radio button")
    public void click_two_way_option() {
        FlightPage.chooseTwoWayOption();
    }

    @And("Select city")
    public void select_city() throws InterruptedException {
        FlightPage.inputFrom();
    }
    @And("Select destination city")
    public void select_destination_city() {
        FlightPage.inputToWhere();
    }
    @And("Click search button")
    public void click_search_button() {
        FlightPage.clickSearch();
    }
    @When("From the results page, select take-off time from slider")
    public void arrangeFirst_slider() throws InterruptedException {
        SearchResultsPage.setTakeOffTime();
    }

    @When("From the results page, select landing time from the second slider")
    public void arrangeSecond_slider() throws InterruptedException {
        SearchResultsPage.setLandingTime();
    }
    @Then("After selections, check the time intervals of the results")
    public void check_if_the_time_isTrue() throws InterruptedException {
        SearchResultsPage.checkTheResult();
    }

}

