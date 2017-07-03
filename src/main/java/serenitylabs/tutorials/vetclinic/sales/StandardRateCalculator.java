package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

/**
 * Created by john on 03/07/17.
 */
public class StandardRateCalculator implements TaxRateCalculator {
    @Override
    public TaxRate rateFor(LineItem item) {
        return new TaxRate(0.23,"Standard");
    }
}
