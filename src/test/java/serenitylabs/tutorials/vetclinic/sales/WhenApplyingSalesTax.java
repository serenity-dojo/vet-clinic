package serenitylabs.tutorials.vetclinic.sales;

import org.junit.Test;
import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.SalesTax;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static serenitylabs.tutorials.vetclinic.sales.model.ProductCategory.*;

public class WhenApplyingSalesTax {

    private final static double NINE_PERCENT = 0.09;
    private final static double THIRTEEN_POINT_FIVE_PERCENT = 0.135;
    private final static double TWENTY_THREE_PERCENT = 0.23;
    private final static double ZER0_PERCENT = 0.00;


    @Test
    public void crisps_should_be_charged_at_the_reduced_rate() {
        // GIVEN
        LineItem crisps = LineItem.forASaleOf(1)
                                       .itemCalled("salt and vinegar crisps")
                                       .inCategory(Snacks)
                                       .withAUnitPriceOf(3.00);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(crisps);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(NINE_PERCENT).withName("Reduced").forAnAmountOf(0.27);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));

    }

    @Test
    public void over_100_euros_of_crisps_should_is_charged_at_a_higher_reduced_rate() {
        // GIVEN
        LineItem crispsOver100 = LineItem.forASaleOf(50)
                .itemCalled("salt and vinegar crisps")
                .inCategory(Snacks)
                .withAUnitPriceOf(3.00);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(crispsOver100);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(THIRTEEN_POINT_FIVE_PERCENT).withName("Reduced").forAnAmountOf(20.25);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));

    }

    @Test
    public void toys_should_be_charged_at_the_standard_rate() {
        // GIVEN
        LineItem toy = LineItem.forASaleOf(1)
                .itemCalled("Teady Bear")
                .inCategory(Toys)
                .withAUnitPriceOf(5.00);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(toy);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(TWENTY_THREE_PERCENT).withName("Standard").forAnAmountOf(1.1500000000000001);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));

    }

    @Test
    public void book_should_be_charged_at_the_zero_rate() {
        // GIVEN
        LineItem book = LineItem.forASaleOf(2)
                .itemCalled("How to Book")
                .inCategory(Books)
                .withAUnitPriceOf(5.00);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(book);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(ZER0_PERCENT).withName("Zero").forAnAmountOf(0);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));

    }
}
