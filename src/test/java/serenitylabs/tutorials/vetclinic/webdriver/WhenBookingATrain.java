package serenitylabs.tutorials.vetclinic.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.ArriveBefore;

public class WhenBookingATrain {
    WebDriver driver;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://www.sydneytrains.info/");
    }

    @Test
    public void should_be_able_to_plan_a_trip() {

        Traveller traveller = new Traveller(driver);
        traveller.departureStationIs("Town Hall");
        traveller.destinationStationIs("Parramatta");
        traveller.theTrainShould(ArriveBefore, 10, 15, TravelDay.Tomorrow);
        traveller.planTrip();

        TripPreferences displayedTripPreferences = traveller.displayedTripPreferences();

        TripPreferences expectedTripPreferences
                = TripPreferences.arrivingOrDeparting("arrive before")
                .from("Town Hall Station, Sydney")
                .to("Parramatta Station, Parramatta")
                .arrivingOn("Tomorrow")
                .at("10","15");

        assertThat(displayedTripPreferences, equalTo(expectedTripPreferences));
    }


    @After
    public void shutdown() {
        driver.quit();
    }
}
