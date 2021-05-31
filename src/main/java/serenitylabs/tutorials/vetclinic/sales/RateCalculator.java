package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.ProductCategory;
import serenitylabs.tutorials.vetclinic.sales.model.SalesTaxRatesName;

import java.util.HashMap;
import java.util.Map;

public class RateCalculator implements TaxRateCalculator {


   @Override
    public TaxRate rateFor(LineItem item) {

       //Assign category to TaxRateName
       Map<ProductCategory, SalesTaxRatesName> salesTaxRates = new HashMap<>();

       salesTaxRates.put(ProductCategory.Books, SalesTaxRatesName.Zero);
       salesTaxRates.put(ProductCategory.Medicine, SalesTaxRatesName.Zero);
       salesTaxRates.put(ProductCategory.Snacks, SalesTaxRatesName.Reduced);
       salesTaxRates.put(ProductCategory.SoftDrinks, SalesTaxRatesName.Reduced);
       salesTaxRates.put(ProductCategory.Toys, SalesTaxRatesName.Standard);
       salesTaxRates.put(ProductCategory.PetFood, SalesTaxRatesName.Standard);

       double rate = 0.00;
       String itemTaxRateName = "";

       //category matched item category
       ProductCategory itemCategory = item.getCategory();

       for (ProductCategory category : salesTaxRates.keySet()) {

           if (itemCategory == category) {

               itemTaxRateName = salesTaxRates.get(category).toString();
           }

       }


       //Assign rate for each TaxRateName
       for (SalesTaxRatesName ratesName : salesTaxRates.values()) {
           if(itemTaxRateName == ratesName.name()) {
               switch (ratesName) {
                   case Standard:
                       rate = 0.23;
                       break;

                   case Zero:
                       rate = 0.00;
                       break;

                   case Reduced:
                       if (item.getTotal() > 100) {
                           rate = 0.135;
                       }
                       else
                       {
                           rate = 0.09;
                       }
                       break;

               }
           }

       }
       return new TaxRate(rate,itemTaxRateName);
   }
}
