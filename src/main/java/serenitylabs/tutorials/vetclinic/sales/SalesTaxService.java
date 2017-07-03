package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.ProductCategory;
import serenitylabs.tutorials.vetclinic.sales.model.SalesTax;

import java.util.HashMap;
import java.util.Map;

import static serenitylabs.tutorials.vetclinic.sales.model.ProductCategory.*;

public class SalesTaxService {

    public SalesTax salesTaxEntryFor(LineItem item) {

        TaxRate applicableTaxRate = taxRateFor(item);

        return SalesTax.atRateOf(applicableTaxRate.getRate())
                .withName(applicableTaxRate.getName())
                .forAnAmountOf(item.getTotal() * applicableTaxRate.getRate());
    }

    private static Map<ProductCategory, TaxRateCalculator> CALCULATOR_PER_PRODUCT =
            new HashMap<>();
    static {
        CALCULATOR_PER_PRODUCT.put(Snacks, new ReducedRateCalculator());
        CALCULATOR_PER_PRODUCT.put(SoftDrinks, new ReducedRateCalculator());
        CALCULATOR_PER_PRODUCT.put(Books, new ZeroRateCalculator());
        CALCULATOR_PER_PRODUCT.put(Medicine, new ZeroRateCalculator());
    }

    private TaxRate taxRateFor(LineItem item) {
        return CALCULATOR_PER_PRODUCT
                .getOrDefault(item.getCategory(), new StandardRateCalculator())
                .rateFor(item);
    }
}
