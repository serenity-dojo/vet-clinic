package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

import java.util.function.Function;

/**
 * Created by john on 03/07/17.
 */
public interface TaxRateCalculator extends Function<LineItem, TaxRate> {}
