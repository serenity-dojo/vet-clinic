package serenitylabs.tutorials.vetclinic.playingball.sales.model;

import java.util.Objects;

public class LineItemEntity {

	private final double unitCost;
	private final int quanity;
	private final String description;
	private final ProductCategoryEnum category;

	public LineItemEntity(double unitCost, int quanity, String description, ProductCategoryEnum category) {
		this.unitCost = unitCost;
		this.quanity = quanity;
		this.description = description;
		this.category = category;
	}

	public static ItemICalled forASaleOf(int quanity) {
		return new LineItemEntityBuilder(quanity);
	}

	/**
	 * @return the unitCost
	 */
	public double getUnitCost() {
		return unitCost;
	}

	/**
	 * @return the quanity
	 */
	public int getQuanity() {
		return quanity;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	public double getTotal() {
		return quanity * unitCost;
	}

	/**
	 * @return the category
	 */
	public ProductCategoryEnum getCategory() {
		return category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, description, quanity, unitCost);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof LineItemEntity)) {
			return false;
		}
		LineItemEntity other = (LineItemEntity) obj;
		return category == other.category && Objects.equals(description, other.description) && quanity == other.quanity
				&& Double.doubleToLongBits(unitCost) == Double.doubleToLongBits(other.unitCost);
	}

	@Override
	public String toString() {
		return "LineItemEntity [unitCost=" + unitCost + ", quanity=" + quanity + ", description=" + description
				+ ", category=" + category + "]";
	}

}