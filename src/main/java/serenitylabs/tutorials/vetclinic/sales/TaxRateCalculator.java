package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

/**
 * Created by john on 03/07/17.
 */
public interface TaxRateCalculator {
    TaxRate rateFor(LineItem item);
}
