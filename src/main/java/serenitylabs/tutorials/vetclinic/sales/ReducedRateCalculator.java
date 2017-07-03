package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

/**
 * Created by john on 03/07/17.
 */
public class ReducedRateCalculator implements TaxRateCalculator {
    @Override
    public TaxRate rateFor(LineItem item) {
        if (item.getTotal() > 100.0) {
            return new TaxRate(0.135, "Reduced");
        }
        return new TaxRate(0.09, "Reduced");
    }
}
