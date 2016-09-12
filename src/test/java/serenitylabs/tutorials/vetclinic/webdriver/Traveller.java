package serenitylabs.tutorials.vetclinic.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Traveller {
    private final WebDriver driver;

    TripPlannerForm tripPlannerForm;
    TripSummaryView tripSummaryView;

    public Traveller(WebDriver driver) {
        this.driver = driver;

        tripPlannerForm = new TripPlannerForm();
        tripSummaryView = new TripSummaryView();

        PageFactory.initElements(driver, tripPlannerForm);
        PageFactory.initElements(driver, tripSummaryView);

    }


    public void planTrip() {
        tripPlannerForm.submitButton.click();
    }

    public void theTrainShould(DeparturePreference departurePreference,
                               int hour,
                               int minute,
                               TravelDay travelDay) {

        driver.findElement(TripPlannerForm.departureButtonFor(departurePreference)).click();

        new Select(tripPlannerForm.travelDay).selectByIndex(travelDay.getDaysInFuture());

        tripPlannerForm.selectDepartureOrArrivalTime(hour, minute);

    }

    public void destinationStationIs(String station) {
        tripPlannerForm.destination.sendKeys(station);
    }

    public void departureStationIs(String station) {
        tripPlannerForm.departure.sendKeys(station);
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
