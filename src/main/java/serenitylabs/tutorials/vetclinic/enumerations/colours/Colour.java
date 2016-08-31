package serenitylabs.tutorials.vetclinic.enumerations.colours;

import java.util.HashMap;
import java.util.Map;

public enum Colour {
    Red(true), Orange(false), Yellow(true), Green(false), Blue(true), Violet(false), Black(false), White(false);

    private boolean isPrimary ;

    Colour(Boolean isPrimary){
        this.isPrimary= isPrimary;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public Colour getOpposite() {
        return opposite.get(Colour.this);
    }

    private static Map<Colour,Colour> opposite= new HashMap<Colour,Colour>();

    static {
        opposite.put(Colour.Black,Colour.White);
        opposite.put(Colour.White,Colour.Black);
        opposite.put(Colour.Red,Colour.Green);
        opposite.put(Colour.Green,Colour.Red);
        opposite.put(Colour.Blue,Colour.Yellow);
        opposite.put(Colour.Yellow,Colour.Blue);
        opposite.put(Colour.Orange,Colour.Violet);
        opposite.put(Colour.Violet,Colour.Orange);
    }

}
