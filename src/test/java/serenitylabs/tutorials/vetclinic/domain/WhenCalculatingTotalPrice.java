package serenitylabs.tutorials.vetclinic.domain;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Test;

public class WhenCalculatingTotalPrice {

	@Test
	public void total_counsaltation_price_should_include_20_percent_tax()
			throws Exception {
		// Given
		int netPrice = 100;
		// When
		int totalPrice = TotalconsultationPrice.includingTax().forANetPriceOf(
				netPrice);
		// Then

		assertThat(totalPrice, equalTo(120));
	}

}
