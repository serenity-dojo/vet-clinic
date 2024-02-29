package serenitylabs.tutorials.vetclinic.domain;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;

public class WhenCalculatingTotalPricesTests {
	
	/*
	 * This TestNg test is representing test validation for 'Vet Clinic Tutorial 2 -
	 * Hamcrest Matchers' modules Exercise - 'Step 1 - Replace JUnit asserts with
	 * Hamcrest asserts' and 'Step 2 - Hamcrest comparison assertions'
	 * implementation
	 * 
	 */
	@Test
	public void total_consultation_price_should_include_20_percent_tax() {
	System.out.println("\nThis is 'Step 1 & Step 2 - simple Hamcrest asserts' Test methode-13th implementation");
	// Arrange - GIVEN
	int netPrice = 250;

	// Act - WHEN
	int totalPrice = TotalConsultationPrice.includingTax().forANetPriceOf(netPrice);
	System.out.println("\nCalculated Total Net price : " + totalPrice);

	// Assert - THEN
	assertThat(totalPrice,greaterThan(150));
	}
	

}