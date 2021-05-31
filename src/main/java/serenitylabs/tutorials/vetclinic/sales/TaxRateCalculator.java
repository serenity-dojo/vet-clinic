package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

public interface TaxRateCalculator {
    TaxRate rateFor(LineItem item);
}
