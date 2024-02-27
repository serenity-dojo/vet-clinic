package serenitylabs.tutorials.vetclinic.playingball.sales;
import java.util.function.Function;
import serenitylabs.tutorials.vetclinic.playingball.sales.model.LineItem;

public interface TaxRateCalculator extends Function<LineItem, TaxRate> {

}
