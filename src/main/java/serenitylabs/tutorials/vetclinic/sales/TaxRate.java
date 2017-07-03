package serenitylabs.tutorials.vetclinic.sales;

public class TaxRate {
    private final double rate;
    private final String name;

    public TaxRate(double rate, String name) {
        this.rate = rate;
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public String getName() {
        return name;
    }
}
