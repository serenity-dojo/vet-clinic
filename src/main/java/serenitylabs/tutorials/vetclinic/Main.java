package serenitylabs.tutorials.vetclinic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.assertj.core.util.Lists;

import sun.awt.SunHints.Value;

public class Main {

	public static void main(String[] args) {
		Pet fido=new Pet("Fido",Breed.Dog,20);
		Pet puppy=new Pet("Puppy",Breed.Dog,30);
		Pet tomy=new Pet("Tomy",Breed.Dog,10);
		Pet brrom=new Pet("Broom",Breed.Dog,10);
		Pet pety=new Pet("Pety",Breed.Dog,10);
		Pet browny=new Pet("Browny",Breed.Dog,10);
		
	
		List<Pet> list=new ArrayList<>();
		Map<String,Pet> map_collection=new HashMap<>();
		Map<String,Pet> new_Map_collection=new HashMap<>();
		Comparator<Pet> byName= (Pet p1,Pet p2)-> p1.getName().compareTo(p2.getName());
		
		map_collection.put(fido.getName(), fido);
		map_collection.put(puppy.getName(), puppy);
		map_collection.put(tomy.getName(), browny);
		
		new_Map_collection.put("Pety", pety);
		new_Map_collection.put("Tomy", puppy);
		new_Map_collection.put("Brownly", pety);
	    map_collection.putIfAbsent("Brrom", brrom);		 
	    
	    new_Map_collection.forEach((key,value)->
	    //code is different in video tutor
	    map_collection.merge(key, value, 
	    		(existingkey, newvalue)->
	    		{      
	    			return existingkey;
	    		})	
	    		
	    		);
	    
	    
	    
		
		System.out.println("Using Map");
		map_collection.forEach((Key,Value)-> System.out.println(Value));
	// not able to replcae if added element using putIfAbsent 
		map_collection.replace("Broom", tomy);
	//	map_collection.replace("Tomy", brrom);
		System.out.println("Replace Tomy  " );
		map_collection.forEach((Key,Value)-> System.out.println(Value));
		
		
		//Set<Pet> setCollection= new HashSet<Pet>();
		list.add(fido);
		list.add(puppy);
		list.add(tomy);
		//list.removeIf(pet -> pet.getWeightInKilos()>20);
		//list.forEach(p-> System.out.println(p));
		List<String> listString=Arrays.asList("Fido","Puppy") ;
		listString.replaceAll(p-> p.toUpperCase());
		System.out.println("Using List replace all UpperCase");
		listString.forEach(p-> System.out.println(p));
		//list.replaceAll(p-> p.getName().toUpperCase());
		//list.forEach(p-> System.out.println(p));
		System.out.println("Using List Comparator");
		list.sort(Comparator.comparing(Pet::getName).thenComparing(Pet::getWeightInKilos));
		list.forEach(p-> System.out.println(p));
		
		
		
	}

}
