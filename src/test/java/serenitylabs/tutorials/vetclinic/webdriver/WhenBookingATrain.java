package serenitylabs.tutorials.vetclinic.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class WhenBookingATrain {
    WebDriver driver;

    @BeforeClass()
    public static void setUpClass(){

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\siddharthk\\Downloads\\chromedriver_win32\\chromedriver.exe");
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://www.sydneytrains.info/");
    }

    @Test
    public void should_be_able_to_plan_a_trip() {

        WebElement toStationElement = driver.findElement(By.id("display_origin"));
        WebElement fromStationElement = driver.findElement(By.id("display_destination"));
        WebElement itdTripDateTimeArr = driver.findElement(By.id("itdTripDateTimeArr"));
        Select dateSelector = new Select(driver.findElement(By.id("itdDate")));
        Select timeHour = new Select(driver.findElement(By.id("itdTimeHour")));
        Select timeSecond = new Select(driver.findElement(By.id("itdTimeMinute")));
        WebElement viewTripElement = driver.findElement(By.id("btnTripPlannerSubmit"));

        //GIVEN
        toStationElement.sendKeys("Town Hall");
        fromStationElement.sendKeys("Parramatta");
        itdTripDateTimeArr.click();
        dateSelector.selectByIndex(1);
        timeHour.selectByVisibleText("10");
        timeSecond.selectByVisibleText("15");

        // WHEN
        viewTripElement.click();

        //THEN

        WebElement originElement = driver.findElement(By.id("name_origin"));
        WebElement destinationElement = driver.findElement(By.id("name_destination"));
        Select arriveDepartElement = new Select(driver.findElement(By.id("SelectArriveDepart")));
        Select hourElement = new Select(driver.findElement(By.id("selectHour")));
        Select minuteElement = new Select(driver.findElement(By.id("selectMinute")));
        Select dateDayMonthYearElement = new Select(driver.findElement(By.id("itdDateDayMonthYear")));

        assertThat(originElement.getAttribute("value"),containsString("Town Hall"));
        assertThat(destinationElement.getAttribute("value"),containsString("Parramatta"));
        assertThat(arriveDepartElement.getFirstSelectedOption().getText(),containsString("arrive before"));
        assertThat(hourElement.getFirstSelectedOption().getText(),containsString("10"));
        assertThat(minuteElement.getFirstSelectedOption().getText(),containsString("15"));
        assertThat(dateDayMonthYearElement.getFirstSelectedOption().getText(),containsString("Tomorrow"));



    }


    @After
    public void shutdown() {
        driver.quit();
    }
}
