package serenitylabs.tutorials.vetclinic.enumerations.colours;

import java.util.HashMap;
import java.util.Map;

public enum Colour {
	Red(true), Orange(false), Yellow(true), 
	Green(false), Blue(true), Violet(false), 
	Black(false), White(false);

	private boolean primaryColour;
			
	private Colour(boolean primaryColour){this.primaryColour = primaryColour;}
	
	public Boolean isPrimary() {return primaryColour;}
	public Colour theOpposite() {return OPPOSITECOLOURS.get(this);}
	
	static Map<Colour, Colour> OPPOSITECOLOURS = new HashMap<>();
	static
	{
		OPPOSITECOLOURS.put(Red, Green);
		OPPOSITECOLOURS.put(Green, Red);
		OPPOSITECOLOURS.put(Blue, Orange);
		OPPOSITECOLOURS.put(Orange, Blue);
		OPPOSITECOLOURS.put(Violet, Yellow);
		OPPOSITECOLOURS.put(Yellow, Violet);
		OPPOSITECOLOURS.put(Black, White);
		OPPOSITECOLOURS.put(White, Black);
	}
}
