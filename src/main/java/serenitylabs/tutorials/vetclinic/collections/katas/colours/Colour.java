package serenitylabs.tutorials.vetclinic.collections.katas.colours;

import com.google.common.collect.Maps;

import java.util.Map;

public enum  Colour {
    Red(true), Orange(false), Yellow(true), Green(false), Blue(true), Violet(false), Black(false), White(false);


    private final boolean isPrimary;

    Colour(boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public Colour getOpposite() {
        return OPPOSITES.get(this);
    }

    private static final Map<Colour, Colour> OPPOSITES = Maps.newHashMap();
    static {
        OPPOSITES.put(Red, Green);
        OPPOSITES.put(Green, Red);
        OPPOSITES.put(Blue, Orange);
        OPPOSITES.put(Orange, Blue);
        OPPOSITES.put(Violet, Yellow);
        OPPOSITES.put(Yellow, Violet);
        OPPOSITES.put(Black, White);
        OPPOSITES.put(White, Black);

    }
}
