package serenitylabs.tutorials.vetclinic.webdriver.bookingatrain;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static serenitylabs.tutorials.vetclinic.webdriver.bookingatrain.DepartureOptions.*;

public class TripPlannerForm {
    static final Map<DepartureOptions, By> DEPARTURE_OPTIONS = new HashMap<>();
    static {

        DEPARTURE_OPTIONS.put(LeaveNow, By.xpath("//label[@class='btn btn-default now ng-star-inserted']"));
        DEPARTURE_OPTIONS.put(LeaveAfter, By.xpath("//label[@class='btn btn-default leaving ng-star-inserted']"));
        DEPARTURE_OPTIONS.put(ArriveBy, By.xpath("//label[@class='btn btn-default arriving ng-star-inserted']"));
    }
}
