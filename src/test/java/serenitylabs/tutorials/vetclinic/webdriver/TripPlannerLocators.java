package serenitylabs.tutorials.vetclinic.webdriver;

import org.openqa.selenium.By;

/**
 * Created by siddharthk on 9/18/2016.
 */
public class TripPlannerLocators {
    public static final By ARRIVE_OR_DEPART = By.id("SelectArriveDepart");
    public static final By FROM_STATION = By.id("name_origin");
    public static final By DESTINATION_STATION = By.id("name_origin");
    public static final By HOUR = By.id("itdDateDayMonthYear");
    public static final By MINUTES = By.id("itdDateDayMonthYear");
    public static By ARRIVAL_DATE = By.id("itdDateDayMonthYear");
}
