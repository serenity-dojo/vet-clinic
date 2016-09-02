package serenitylabs.tutorials.vetclinic.enumerations.colours;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Colour {

    Red(true),Green(true), Blue(true), Orange(false),Violet(false),Yellow(false),Black(false), White(false);

    boolean primary;
    static final Map<Colour,Colour> OPPOSITE_MAP = new HashMap<Colour,Colour>();
   static  {
       OPPOSITE_MAP.put(Colour.Red,Colour.Green);
       OPPOSITE_MAP.put(Colour.Green,Colour.Red);
       OPPOSITE_MAP.put(Colour.Blue,Colour.Orange);
       OPPOSITE_MAP.put(Colour.Orange,Colour.Blue);
       OPPOSITE_MAP.put(Colour.Yellow,Colour.Violet);
       OPPOSITE_MAP.put(Colour.Violet,Colour.Yellow);
       OPPOSITE_MAP.put(Colour.Black,Colour.White);
       OPPOSITE_MAP.put(Colour.White,Colour.Black);

    }
    Colour(boolean primary) {
        this.primary = primary;
    }

    public static List<String> primaryColors() {
        return convertToStrings(Arrays.asList(Colour.values()).stream().filter(colour -> colour.primary).collect(Collectors.toList()));
    }

    private static List<String> convertToStrings(List<Colour> colors) {
        return colors.stream().map(colour -> colour.toString()).collect(Collectors.toList());
    }

    public static List<String> nonPrimaryColors() {
        List<Colour> colors = Arrays.asList(Colour.values()).stream().filter(colour -> !colour.primary).collect(Collectors.toList());
        return convertToStrings(colors);
    }

    public boolean isPrimary() {
        return primary;
    }

    public static Colour oppositeOf(Colour colour) {
        return OPPOSITE_MAP.get(colour);
    }
}
