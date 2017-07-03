package serenitylabs.tutorials.vetclinic.sales;

import org.junit.Assert;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.TaxEntry;
//import serenitylabs.tutorials.vetclinic.sales.service.SalesTaxService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static serenitylabs.tutorials.vetclinic.sales.model.ProductCategory.Snacks;

public class WhenApplyingSalesTax {

    private final static double NINE_PERCENT = 0.09;

    @Test
    public void crisps_should_be_charged_at_the_reduced_rate() {
        // GIVEN
        LineItem crisps = LineItem.forASaleOf(1)
                                       .itemCalled("salt and vinegar crisps")
                                       .inCategory(Snacks)
                                       .withAUnitPriceOf(1.50);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        TaxEntry calculatedTaxEntry = salesTaxService.salesTaxEntryFor(crisps);

        // THEN
        TaxEntry expectedTaxEntry = TaxEntry.atRateOf(NINE_PERCENT).withName("Reduced").forAnAmountOf(0.14);

        assertThat(calculatedTaxEntry, equalTo(expectedTaxEntry));


    }
}
