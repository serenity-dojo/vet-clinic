package serenitylabs.tutorials.vetclinic.sales.model;

import java.util.Objects;

public class TaxEntry {
    private final String name;
    private final double rate;
    private final double amount;

    public TaxEntry(String name, double rate, double amount) {
        this.name = name;
        this.rate = rate;
        this.amount = amount;
    }


    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public double getAmount() {
        return amount;
    }

    public static WithName atRateOf(double rate) {
        return new TaxEntryBuilder(rate);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxEntry taxEntry = (TaxEntry) o;
        return Double.compare(taxEntry.rate, rate) == 0 &&
                Double.compare(taxEntry.amount, amount) == 0 &&
                Objects.equals(name, taxEntry.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rate, amount);
    }


    @Override
    public String toString() {
        return "TaxEntry{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", amount=" + amount +
                '}';
    }

    public interface WithName {
        TaxEntryBuilder withName(String name);
    }

    public static class TaxEntryBuilder implements WithName {
        private double rate;
        private String name;

        public TaxEntryBuilder(double rate) {
            this.rate = rate;
        }

        public TaxEntryBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public TaxEntry forAnAmountOf(double amount) {
            return new TaxEntry(name, rate, amount);
        }
    }
}
