package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

/**
 * Created by john on 03/07/17.
 */
public class ZeroRateCalculator implements TaxRateCalculator {
    @Override
    public TaxRate rateFor(LineItem item) {
        return new TaxRate(0.0,"Zero");
    }
}
