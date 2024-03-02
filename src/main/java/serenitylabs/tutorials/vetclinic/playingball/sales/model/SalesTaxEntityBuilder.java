package serenitylabs.tutorials.vetclinic.playingball.sales.model;

public class SalesTaxEntityBuilder implements IWithName {

	private double rate;
	private String name;

	  public SalesTaxEntityBuilder(double rate) {
          this.rate = rate;
      }

      public SalesTaxEntityBuilder withName(String strName) {
          this.name = strName;
          return this;
      }
      
      public SalesTaxEntity forAnAmountOf(double amount) {
          return new SalesTaxEntity(name, rate, amount);
      }

}
