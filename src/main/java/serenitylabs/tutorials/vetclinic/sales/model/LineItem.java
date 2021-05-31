package serenitylabs.tutorials.vetclinic.sales.model;

import java.util.Objects;

public class LineItem {
    private final double unitCost;
    private final int quanity;
    private final String description;
    private final ProductCategory category;

    public LineItem(double unitCost, int quanity, String description, ProductCategory category) {
        this.unitCost = unitCost;
        this.quanity = quanity;
        this.description = description;
        this.category = category;
    }

    public static ItemCalled forASaleOf(int quanity) {
        return new LineItemBuilder(quanity);
    }

    public double getUnitCost() {
        return unitCost;
    }

    public int getQuanity() {
        return quanity;
    }

    public String getDescription() {
        return description;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public double getTotal() {
        return quanity * unitCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return Double.compare(lineItem.unitCost, unitCost) == 0 &&
                quanity == lineItem.quanity &&
                Objects.equals(description, lineItem.description) &&
                category == lineItem.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitCost, quanity, description, category);
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "unitCost=" + unitCost +
                ", quanity=" + quanity +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }

    public interface ItemCalled {
        InCategory itemCalled(String itemName);
    }

    public interface InCategory {
        LineItemBuilder inCategory(ProductCategory category);
    }

    public static class LineItemBuilder implements ItemCalled, InCategory {
        private int quanity;
        private String itemName;
        private ProductCategory category;

        public LineItemBuilder(int quanity) {
            this.quanity = quanity;
        }

        public InCategory itemCalled(String itemName) {
            this.itemName = itemName;
            return this;
        }

        public LineItemBuilder inCategory(ProductCategory category) {
            this.category = category;
            return this;
        }

        public LineItem withAUnitPriceOf(double price) {
            return new LineItem(price, quanity, itemName, category);
        }
    }
}
