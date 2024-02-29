package serenitylabs.tutorials.vetclinic.playingball.sales.model;
import java.util.Objects;

public class SalesTaxEntity {

	private final String name;
	private final double rate;
	private final double amount;

	public SalesTaxEntity(String name, double rate, double amount) {
		this.name = name;
		this.rate = rate;
		this.amount = amount;
	}

	public static IWithName atRateOf(double rate) {
		return new SalesTaxEntityBuilder(rate);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, name, rate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof SalesTaxEntity)) {
			return false;
		}
		SalesTaxEntity other = (SalesTaxEntity) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(rate) == Double.doubleToLongBits(other.rate);
	}

	@Override
	public String toString() {
		return "SalesTaxEntity [name=" + name + ", rate=" + rate + ", amount=" + amount + "]";
	}

}