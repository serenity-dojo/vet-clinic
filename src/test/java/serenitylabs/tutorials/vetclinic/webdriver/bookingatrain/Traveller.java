package serenitylabs.tutorials.vetclinic.webdriver.bookingatrain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import static serenitylabs.tutorials.vetclinic.webdriver.bookingatrain.DepartureOptions.*;

public class Traveller {
    private WebDriver driver;
    public Traveller(WebDriver driver) {
        this.driver = driver;
    }
    void departurePointIs(String departurePoint) {
        driver.findElement(By.id("mat-input-0")).sendKeys(departurePoint);
        driver.findElement(By.xpath("//div[contains(text(),'Town Hall Station')]")).click();
    }
    void arrivingPointIs(String arrivingPoint) {
        driver.findElement(By.id("mat-input-1")).sendKeys(arrivingPoint);
        driver.findElement(By.xpath("//div[contains(text(),'Parramatta Station')]")).click();
    }
    void theTrainShould(DepartureOptions departureOptions,
                                TravelDay day,
                                int hour,
                                int minutes) {
        //click Living now
        driver.findElement(By.xpath("//span[@class='tab-title']")).click();
        //choose Arriving option
        driver.findElement(DEPARTURE_OPTIONS.get(departureOptions)).click();

        //select day
        new Select(driver.findElement(By.cssSelector("#search-select-date"))).selectByIndex(day.getDaysInFuture());
        //select hour
        new Select(driver.findElement(By.cssSelector("#search-select-hour"))).selectByVisibleText(TIME_UNIT_FORMAT.format(hour));
        //select minute
        new Select(driver.findElement(By.cssSelector("#search-select-minute"))).selectByVisibleText(TIME_UNIT_FORMAT.format(minutes));

    }
    private static final DecimalFormat TIME_UNIT_FORMAT = new DecimalFormat("##");//The "#.##" means it will print the number with maximum two decimal places
    static final Map<DepartureOptions, By> DEPARTURE_OPTIONS = new HashMap<>();
    static {

        DEPARTURE_OPTIONS.put(LeaveNow, By.xpath("//label[@class='btn btn-default now ng-star-inserted']"));
        DEPARTURE_OPTIONS.put(LeaveAfter, By.xpath("//label[@class='btn btn-default leaving ng-star-inserted']"));
        DEPARTURE_OPTIONS.put(ArriveBy, By.xpath("//label[@class='btn btn-default arriving ng-star-inserted']"));
    }
    void planATrip() {
        //click Apply button
        driver.findElement(By.xpath("//button[@class='btn btn-primary go-btn date-time-btn ng-tns-c101-1']")).click();
    }
}
