package serenitylabs.tutorials.vetclinic.playingball.sales;
import java.util.function.Function;
import serenitylabs.tutorials.vetclinic.playingball.sales.model.LineItemEntity;

public interface TaxRateCalculator extends Function<LineItemEntity, TaxRate> {

}
