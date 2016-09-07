package serenitylabs.tutorials.vetclinic.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.ArriveBefore;
import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.LeaveAfter;

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

        departureStationIs("Town Hall");
        destinationStationIs("Parramatta");
        theTrainShould(ArriveBefore, 10, 15, TravelDay.Tomorrow);
        planTrip();

        List<WebElement> tripOptions = driver.findElements(By.cssSelector(".journeyValue"));

        String arriveOrDepart = new Select(driver.findElement(By.id("SelectArriveDepart"))).getFirstSelectedOption().getText();
        String displayedOrigin = driver.findElement(By.id("name_origin")).getAttribute("value");
        String displayedDestination = driver.findElement(By.id("name_destination")).getAttribute("value");
        String arrivalDay = new Select(driver.findElement(By.id("itdDateDayMonthYear"))).getFirstSelectedOption().getText();
        String arrivalHour = new Select(driver.findElement(By.id("selectHour"))).getFirstSelectedOption().getText();
        String arrivalMinute = new Select(driver.findElement(By.id("selectMinute"))).getFirstSelectedOption().getText();

        assertThat(tripOptions.size(), is(greaterThan(0)));

        assertThat(arriveOrDepart, equalTo("arrive before"));
        assertThat(displayedOrigin, containsString("Town Hall"));
        assertThat(displayedDestination, containsString("Parramatta"));
        assertThat(arriveOrDepart, equalTo("arrive before"));
        assertThat(arrivalDay, containsString("Tomorrow"));
        assertThat(arrivalHour, equalTo("10"));
        assertThat(arrivalMinute, equalTo("15"));
    }

    private void planTrip() {
        driver.findElement(By.name("btnTripPlannerSubmit")).click();
    }

    static final Map<DeparturePreference, By> DEPARTURE_RADIO_BUTTONS = new HashMap<>();
    static {
        DEPARTURE_RADIO_BUTTONS.put(ArriveBefore, By.id("itdTripDateTimeArr"));
        DEPARTURE_RADIO_BUTTONS.put(LeaveAfter, By.id("itdTripDateTimeDep"));
    }

    private static final DecimalFormat TIME_UNIT_FORMAT = new DecimalFormat("##");

    private void theTrainShould(DeparturePreference departurePreference,
                                int hour,
                                int minute,
                                TravelDay travelDay) {
        driver.findElement(DEPARTURE_RADIO_BUTTONS.get(departurePreference)).click();

        new Select(driver.findElement(By.cssSelector("#itdDate")))
                                      .selectByIndex(travelDay.getDaysInFuture());

        Select hourList = new Select(driver.findElement(By.cssSelector("#itdTimeHour")));
        hourList.selectByVisibleText(TIME_UNIT_FORMAT.format(hour));

        Select minuteList = new Select(driver.findElement(By.cssSelector("#itdTimeMinute")));
        minuteList.selectByVisibleText(TIME_UNIT_FORMAT.format(minute));

    }

    private void destinationStationIs(String station) {
        driver.findElement(By.id("display_destination")).sendKeys(station);
    }

    private void departureStationIs(String station) {
        driver.findElement(By.id("display_origin")).sendKeys(station);
    }


    @After
    public void shutdown() {
        driver.quit();
    }
}
