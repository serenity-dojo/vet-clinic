package serenitylabs.tutorials.vetclinic.enumerations.colours;

//Black-White, Red-Green, Blue-Yellow and Orange-Violet
public enum Colour {
    Red(true,"Green"), Orange(false,"Blue"), Yellow(true,"Violet"), Green(false,"Red"),
    Blue(true,"Orange"), Violet(false,"Yellow"), Black(false,"White") ,White(false,"Black");

    public boolean isPrimary() {
        return isPrimary;
    }

    public Colour getOppositeColor() {
        return Colour.valueOf(oppositeColor);
    }

    private final boolean isPrimary;
    private final String oppositeColor;

    Colour(boolean isPrimary, String oppositeColor) {

        this.isPrimary = isPrimary;
        this.oppositeColor = oppositeColor;
    }
}
