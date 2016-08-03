package serenitylabs.tutorials.vetclinic.domain;

public class TotalConsultationPrice {
    public static TotalConsultationPrice includingTax() {
        return new TotalConsultationPrice();
    }

    public int forANetPriceOf(double netPrice) {
        return (int) (netPrice * 1.20);
    }
}
