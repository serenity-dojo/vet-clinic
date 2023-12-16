package serenitylabs.tutorials.vetclinic.webdriver.bookingatrain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import serenitylabs.tutorials.vetclinic.webdriver.bookingatrain.DepartureOptions;
import serenitylabs.tutorials.vetclinic.webdriver.bookingatrain.TravelDay;
import serenitylabs.tutorials.vetclinic.webdriver.bookingatrain.Traveller;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;
import static serenitylabs.tutorials.vetclinic.webdriver.bookingatrain.DepartureOptions.*;
import static serenitylabs.tutorials.vetclinic.webdriver.bookingatrain.TravelDay.*;

public class WhenBookingATrain {
    WebDriver driver;
    @Before
    public void setup() {
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://transportnsw.info/");

    }
    @Test
    public void shouldBeAbleToPlanATrip() {
        //By passing driver to the Traveller constructor,
        // you are providing the Traveller object with the means to interact with the web browser.
        Traveller traveller = new Traveller(driver);

        traveller.departurePointIs("Town Hall Station");
        traveller.arrivingPointIs("Parramatta");
        verifyThatTheFoundOptionsListIsGreaterThanZero();
        traveller.theTrainShould(ArriveBy, Tomorrow, 10, 35);
        traveller.planATrip();
        //verify that the selected date/time options are displayed
        assertThat(driver.findElement(By.xpath("//span[@class='tab-title']")).
                getText()).contains("Arr 10:35, tomorrow");

        //the list of found items is greater than zero
        verifyThatTheFoundOptionsListIsGreaterThanZero();
    }


    static final Map<DepartureOptions, By> DEPARTURE_OPTIONS = new HashMap<>();
    static {

        DEPARTURE_OPTIONS.put(LeaveNow, By.xpath("//label[@class='btn btn-default now ng-star-inserted']"));
        DEPARTURE_OPTIONS.put(LeaveAfter, By.xpath("//label[@class='btn btn-default leaving ng-star-inserted']"));
        DEPARTURE_OPTIONS.put(ArriveBy, By.xpath("//label[@class='btn btn-default arriving ng-star-inserted']"));
    }


    private void verifyThatTheFoundOptionsListIsGreaterThanZero() {
        //the list of found items is greater than zero
        List<WebElement> foundOptionsList = driver.findElements(By.xpath("//div[@card-header]"));
        assertThat(foundOptionsList.size()).isGreaterThan(0);
    }



    @After
    public void shutDown() {
        driver.quit();
    }


}
