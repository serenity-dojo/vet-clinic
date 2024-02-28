package serenitylabs.tutorials.vetclinic.playingball.sales.model;

public class LineItemEntityBuilder implements ItemICalled, InICategory {

	@Override
	public LineItemEntityBuilder inCategory(ProductCategoryEnum category) {
		return null;
	}

	@Override
	public InICategory itemCalled(String itemName) {
		return null;
	}

}
