package serenitylabs.tutorials.vetclinic.webdriver.bookingatrain;

public enum TravelDay {
    Today(0), Tomorrow(1);
    private final int daysInFuture;

    TravelDay(int daysInFuture) {
        this.daysInFuture = daysInFuture;
    }

    public int getDaysInFuture() {
        return daysInFuture;
    }
}
