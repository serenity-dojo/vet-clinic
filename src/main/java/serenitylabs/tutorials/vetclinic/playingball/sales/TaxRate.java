package serenitylabs.tutorials.vetclinic.playingball.sales;

public class TaxRate {
	
	private final double rate;
    private final String name;
    
	public TaxRate(double rate, String name) {
		this.rate = rate;
		this.name = name;
	}

	/**
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}