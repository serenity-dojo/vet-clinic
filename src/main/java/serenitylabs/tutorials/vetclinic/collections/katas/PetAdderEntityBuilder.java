package serenitylabs.tutorials.vetclinic.collections.katas;
import java.util.List;
import java.util.Random;
import com.google.common.collect.ImmutableList;
import serenitylabs.tutorials.vetclinic.enumerations.exercises.BreedEnum;
import serenitylabs.tutorials.vetclinic.katas.PetEntity;

public class PetAdderEntityBuilder {
	
	private final int petCount;
	private final static Random random = new Random();
	private final static List<String> PET_NAMES = ImmutableList.of("Fido","Felix","Rover","Spot");
	
	public PetAdderEntityBuilder(int petCount) {
		this.petCount = petCount;
	}

	 private PetEntity somePet(int petCount) {
         return new PetEntity(someName(petCount), someBreed());
     }
	 
	 private BreedEnum someBreed() {
         return BreedEnum.values()[ random.nextInt(BreedEnum.values().length) ];
     }
	 
	 private String someName(int petCount) {
         return PET_NAMES.get(random.nextInt(PET_NAMES.size())) + " " + petCount;
     }

	 public PetHotel petsCheckedIn()  {
         PetHotel hotel = new PetHotel();
         for(int count = 0; count < petCount; count++) {
             hotel.checkIn(somePet(count));
         }
         return hotel;
     }
}