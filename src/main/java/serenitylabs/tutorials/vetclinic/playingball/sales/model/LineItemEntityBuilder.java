package serenitylabs.tutorials.vetclinic.playingball.sales.model;

public class LineItemEntityBuilder implements ItemICalled, InICategory {

	private int quanity;
	private String itemName;
	private ProductCategoryEnum category;

	public LineItemEntityBuilder(int quanity) {
		this.quanity = quanity;
	}

	@Override
	public LineItemEntityBuilder inCategory(ProductCategoryEnum category) {
		this.category = category;
		return this;
	}

	@Override
	public InICategory itemCalled(String itemName) {
		this.itemName = itemName;
		return this;
	}

	public LineItemEntity withAUnitPriceOf(double price) {
		return new LineItemEntity(price, quanity, itemName, category);
	}
}