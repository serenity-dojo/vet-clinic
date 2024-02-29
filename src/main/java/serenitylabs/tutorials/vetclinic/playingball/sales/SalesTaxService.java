package serenitylabs.tutorials.vetclinic.playingball.sales;
import java.util.HashMap;
import java.util.Map;
import serenitylabs.tutorials.vetclinic.playingball.sales.model.LineItemEntity;
import serenitylabs.tutorials.vetclinic.playingball.sales.model.ProductCategoryEnum;
import static serenitylabs.tutorials.vetclinic.playingball.sales.model.ProductCategoryEnum.*;
import serenitylabs.tutorials.vetclinic.playingball.sales.model.SalesTaxEntity;

public class SalesTaxService {

	private static Map<ProductCategoryEnum, TaxRateCalculator> CALCULATOR_PER_PRODUCT = new HashMap<>();

	public SalesTaxEntity salesTaxEntryFor(LineItemEntity item) {
		TaxRate applicableTaxRate = taxRateFor(item);
		return SalesTaxEntity.atRateOf(applicableTaxRate.getRate()).withName(applicableTaxRate.getName())
				.forAnAmountOf(item.getTotal() * applicableTaxRate.getRate());
	}

	private TaxRate taxRateFor(LineItemEntity item) {
		return CALCULATOR_PER_PRODUCT.getOrDefault(item.getCategory(), STANDARD_RATE).apply(item);
	}

	static TaxRateCalculator STANDARD_RATE = (item) -> new TaxRate(0.23, "Standard");

	static TaxRateCalculator ZERO_RATE = (item) -> new TaxRate(0.0, "Zero");

	static TaxRateCalculator REDUCED_RATE = (item) -> {
		double rate = (item.getTotal() > 100.0) ? 0.135 : 0.09;
		return new TaxRate(rate, "Reduced");
	};

	static {
		CALCULATOR_PER_PRODUCT.put(Snacks, REDUCED_RATE);
		CALCULATOR_PER_PRODUCT.put(SoftDrinks, REDUCED_RATE);
		CALCULATOR_PER_PRODUCT.put(Books, ZERO_RATE);
		CALCULATOR_PER_PRODUCT.put(Medicine, ZERO_RATE);
	}

}