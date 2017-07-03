package serenitylabs.tutorials.vetclinic.sales.model;

import java.util.Objects;

public class SalesTax {
    private final String name;
    private final double rate;
    private final double amount;

    public SalesTax(String name, double rate, double amount) {
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
        SalesTax salesTax = (SalesTax) o;
        return (Math.abs(salesTax.rate - rate) < 0.001) &&
                (Math.abs(salesTax.amount - amount) < 0.001) &&
                Objects.equals(name, salesTax.name);
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

        public SalesTax forAnAmountOf(double amount) {
            return new SalesTax(name, rate, amount);
        }
    }
}
