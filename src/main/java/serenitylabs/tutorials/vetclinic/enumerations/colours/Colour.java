package serenitylabs.tutorials.vetclinic.enumerations.colours;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Colour {

    Red(true),Green(true), Blue(true), Orange(false),Violet(false),Yellow(false),Black(false), White(false);

    boolean isPrimary;
    Colour(boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public static List<String> primaryColors() {
        List<Colour> colors = Arrays.asList(Colour.values()).stream().filter(colour -> colour.isPrimary).collect(Collectors.toList());
        return convertToStrings(colors);
    }

    private static List<String> convertToStrings(List<Colour> colors) {
        return colors.stream().map(colour -> colour.toString()).collect(Collectors.toList());
    }

    public static List<String> nonPrimaryColors() {
        List<Colour> colors = Arrays.asList(Colour.values()).stream().filter(colour -> !colour.isPrimary).collect(Collectors.toList());
        return convertToStrings(colors);
    }
}
