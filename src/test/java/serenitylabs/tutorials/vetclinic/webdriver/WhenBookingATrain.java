package serenitylabs.tutorials.vetclinic.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static serenitylabs.tutorials.vetclinic.webdriver.Day.Tomorrow;
import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.ARRIVE_BEFORE;

public class WhenBookingATrain {
    WebDriver driver;

    @BeforeClass()
    public static void setUpClass(){

        /*System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\siddharthk\\Downloads\\chromedriver_win32\\chromedriver.exe");*/
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://www.sydneytrains.info/");
    }

    @Test
    public void should_be_able_to_plan_a_trip() {

        //GIVEN
        Traveller traveller = new Traveller(driver);
        traveller.departureStationIs("Town Hall");
        traveller.arrivalStationIs("Parramatta");
        traveller.theTrainShould(ARRIVE_BEFORE, "10", "15", Tomorrow);

        //WHEN
        traveller.planTheTrip();

        //THEN
        assertThat(getExpectedTripPreference(), equalTo(traveller.getDisplayedTripPreferences()));

    }

    private TripSummary getExpectedTripPreference() {
        return TripSummary.from("Town Hall Station, Sydney")
                .to("Parramatta Station, Parramatta")
                .arrivingBeforeOrLeaveAfter("arrive before","10","15")
                .on("Tomorrow");
    }

    @After
    public void shutdown() {
        driver.quit();
    }
}