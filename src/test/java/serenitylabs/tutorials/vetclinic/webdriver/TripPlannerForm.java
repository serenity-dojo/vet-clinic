package serenitylabs.tutorials.vetclinic.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.ArriveBefore;
import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.LeaveAfter;

public class TripPlannerForm {

    @FindBy(css = "#itdDate")
    public  WebElement travelDay;

    @FindBy(css = "#itdTimeHour")
    public  WebElement timeHour;

    @FindBy(css = "#itdTimeMinute")
    public  WebElement timeMinute;

    @FindBy(id = "display_destination")
    public  WebElement destination;

    @FindBy(id = "display_origin")
    public  WebElement origin;

     final Map<DeparturePreference, By> DEPARTURE_RADIO_BUTTONS = new HashMap<>();

     {
        DEPARTURE_RADIO_BUTTONS.put(ArriveBefore, By.id("itdTripDateTimeArr"));
        DEPARTURE_RADIO_BUTTONS.put(LeaveAfter, By.id("itdTripDateTimeDep"));
    }

    @FindBy(id = "btnTripPlannerSubmit")
    public  WebElement viewTrip;

    public  By departureButtonFor(DeparturePreference departurePreference) {
        return DEPARTURE_RADIO_BUTTONS.get(departurePreference);
    }
}
