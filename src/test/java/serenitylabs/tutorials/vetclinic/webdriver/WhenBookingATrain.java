package serenitylabs.tutorials.vetclinic.webdriver;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.describedAs;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.Arriving;
import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.Leaving;

public class WhenBookingATrain {
    WebDriver driver;

    @Before
    public void setup() {
//      System.setProperty("webdriver.firefox.driver", "/Users/DH3/Documents/JavaCode/vet-clinic_forked/src/test/java/resources/drivers/geckodriver");
        System.setProperty("webdriver.chrome.driver", "/Users/DH3/Documents/JavaCode/vet-clinic_forked/src/test/java/resources/drivers/chromedriver");
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://www.sydneytrains.info/");
//        driver.get("https://transportnsw.info/");
//        driver.findElement(By.cssSelector(".btn-link.more-options-link")).click();
    }

    @Test
    public void should_be_able_to_plan_a_trip() throws Exception {

        departureStationIs("Town Hall Station, Sydney");
        destinationStationIs("Parramatta Station, Parramatta");

        //Expand leaving conditions arrow
//        driver.findElement(By.cssSelector("svg[aria-labelledby='journeySearchArrowDownIconTitle']")).click();
        driver.findElement(By.cssSelector("svg[icon-id='journeySearchClockTitle']")).click();

        theTrainShould(Arriving, 10, 15, TravelDay.Tomorrow);

        //Wait for suggestions window and click
//        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.id("suggestions-To")));
//        driver.findElement(By.id("suggestion-To-0")).click();


        Thread.sleep(3000);

        //Wait for arrow to point up to indicate conditions are available
//        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-labelledby='journeySearchArrowUpIconTitle']")));
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tp-search-time-options")));


        driver.findElement(By.id("search-button")).click();

        List<WebElement> tripOptions = driver.findElements(By.cssSelector(".tripResults"));


//        String arriveOrDepart = new Select(driver.findElement(By.id("SelectArriveDepart"))).getFirstSelectedOption().getText();
//        String displayedOrigin = driver.findElement(By.id("name_origin")).getAttribute("value");
//        String displayedDestination = driver.findElement(By.id("name_destination")).getAttribute("value");
//        String arrivalDay = new Select(driver.findElement(By.id("itdDateDayMonthYear"))).getFirstSelectedOption().getText();
//        String arrivalHour = new Select(driver.findElement(By.id("selectHour"))).getFirstSelectedOption().getText();
//        String arrivalMinute = new Select(driver.findElement(By.id("selectMinute"))).getFirstSelectedOption().getText();

        assertThat(tripOptions.size(), is(greaterThan(0)));

//        assertThat(arriveOrDepart, equalTo("arrive before"));
//        assertThat(displayedOrigin, containsString("Town Hall"));
//        assertThat(displayedDestination, containsString("Parramatta"));
//        assertThat(arriveOrDepart, equalTo("arrive before"));
//        assertThat(arrivalDay, containsString("TravelDay"));
//        assertThat(arrivalHour, equalTo("10"));
//        assertThat(arrivalMinute, equalTo("15"));
    }


    static final Map<DeparturePreference, By> DEPARTURE_RADIO_BUTTONS = new HashMap<>();

    static {
        DEPARTURE_RADIO_BUTTONS.put(Leaving, By.cssSelector(".btn.btn-default.leaving.ng-scope"));
        DEPARTURE_RADIO_BUTTONS.put(Arriving, By.cssSelector(".btn.btn-default.arriving.ng-scope"));
    }

    private void theTrainShould(DeparturePreference arriveBefore,
                                int hour,
                                int minute,
                                TravelDay travelDay) {

        driver.findElement(By.cssSelector(".btn.btn-default.arriving.ng-scope")).click();

        new Select(driver.findElement(By.id("search-select-date"))).selectByIndex(travelDay.getDaysInFuture());
        Select hourList = new Select(driver.findElement(By.id("search-select-hour"))).selectByVisibleText(hour);
        Select minuteList = new Select(driver.findElement(By.id("search-select-minute"))).selectByVisibleText(minute);
    }

    private void destinationStationIs(String station) {
        driver.findElement(By.id("search-input-To")).clear();
        driver.findElement(By.id("search-input-To")).sendKeys(station);
    }

    private void departureStationIs(String station) {
        driver.findElement(By.id("search-input-From")).clear();
        driver.findElement(By.id("search-input-From")).sendKeys(station);
    }


    @After
    public void shutdown() {
        driver.quit();
    }
}
