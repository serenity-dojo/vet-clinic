package serenitylabs.tutorials.vetclinic.enumerations.colours;
import java.util.Map;
import com.google.common.collect.Maps;

public enum ColourEnum {

	Red(true), Orange(false), Yellow(true), Green(false), Blue(true), Violet(false), Black(false), White(false);

	private final boolean isPrimary;
	private static final Map<ColourEnum, ColourEnum> OPPOSITES = Maps.newHashMap();

	ColourEnum(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public ColourEnum opposite() {
		return OPPOSITES.get(this);
	}
	
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