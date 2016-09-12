package serenitylabs.tutorials.vetclinic.webdriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TripSummaryView {

    @FindBy(id="SelectArriveDepart")
    public WebElement arriveOrDepart;

    @FindBy(id="name_origin")
    public WebElement origin;

    @FindBy(id="name_destination")
    public WebElement destination;

    @FindBy(id="itdDateDayMonthYear")
    public WebElement day;

    @FindBy(id="selectHour")
    public WebElement hour;

    @FindBy(id="selectMinute")
    public WebElement minute;
}
