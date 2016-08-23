package serenitylabs.tutorials.vetclinic.domain;

public class TotalconsultationPrice {

	public static TotalConsultantPriceCalculator includingTax() {

		return new TotalConsultantPriceCalculator();
	}

	public static class TotalConsultantPriceCalculator {
		public int forANetPriceOf(int netPrice) {

			return (int) (netPrice + (netPrice * 0.20));
		}

	}

}
