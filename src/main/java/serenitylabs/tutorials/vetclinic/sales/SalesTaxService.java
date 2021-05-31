package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.SalesTax;

public class SalesTaxService {

    private static final double NINE_PERCENT = 0.09;

    public SalesTax salesTaxEntryFor(LineItem item) {

        TaxRate applicableTaxRate = taxRateFor(item);

        return SalesTax.atRateOf(applicableTaxRate.getRate())
                .withName(applicableTaxRate.getName())
                .forAnAmountOf(item.getTotal() * applicableTaxRate.getRate());
    }


    private TaxRate taxRateFor(LineItem item) {
        TaxRateCalculator taxRateCalculator = new RateCalculator();
       return taxRateCalculator.rateFor(item);
    }


}
