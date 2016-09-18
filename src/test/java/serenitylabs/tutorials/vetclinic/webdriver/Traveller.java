package serenitylabs.tutorials.vetclinic.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.DecimalFormat;

public class Traveller {
    private final WebDriver driver;
    TripPlannerForm tripPlannerForm ;
    TripSummaryView tripSummaryView;

    public Traveller(WebDriver driver) {

        this.driver = driver;
        tripPlannerForm = new TripPlannerForm();
        tripSummaryView = new TripSummaryView();

        PageFactory.initElements(driver, tripPlannerForm);
        PageFactory.initElements(driver, tripSummaryView);

    }

    public void planTrip() {
        tripPlannerForm.viewTrip.click();
    }

    private static final DecimalFormat TIME_UNIT_FORMAT = new DecimalFormat("##");

    public void theTrainShould(DeparturePreference departurePreference,
                               int hour,
                               int minute,
                               TravelDay travelDay) {
        driver.findElement(tripPlannerForm.departureButtonFor(departurePreference)).click();

        new Select(tripPlannerForm.travelDay)
                .selectByIndex(travelDay.getDaysInFuture());

        Select hourList = new Select(tripPlannerForm.timeHour);
        hourList.selectByVisibleText(TIME_UNIT_FORMAT.format(hour));

        Select minuteList = new Select(tripPlannerForm.timeMinute);
        minuteList.selectByVisibleText(TIME_UNIT_FORMAT.format(minute));

    }

    public void destinationStationIs(String station) {
        tripPlannerForm.destination.sendKeys(station);
    }

    public void departureStationIs(String station) {
        tripPlannerForm.origin.sendKeys(station);
    }

    public TripPreferences displayedTripPreferences() {

        String arriveOrDepart = new Select(tripSummaryView.arriveOrDepart).getFirstSelectedOption().getText();
        String displayedOrigin = tripSummaryView.origin.getAttribute("value");
        String displayedDestination = tripSummaryView.destination.getAttribute("value");
        String arrivalDay = new Select(tripSummaryView.day).getFirstSelectedOption().getText();
        String arrivalHour = new Select(tripSummaryView.hour).getFirstSelectedOption().getText();
        String arrivalMinute = new Select(tripSummaryView.minute).getFirstSelectedOption().getText();

        return TripPreferences.arrivingOrDeparting(arriveOrDepart)
                .from(displayedOrigin)
                .to(displayedDestination)
                .arrivingOn(arrivalDay)
                .at(arrivalHour, arrivalMinute);
    }
}
