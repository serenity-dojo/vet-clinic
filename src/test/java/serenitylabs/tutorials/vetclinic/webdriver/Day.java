package serenitylabs.tutorials.vetclinic.webdriver;

/**
 * Created by siddharthk on 9/18/2016.
 */
public enum Day {
    Today (0),Tomorrow(1);

    private int day;

    Day(int day) {

        this.day = day;
    }

    public int getDay() {
        return day;
    }
}
