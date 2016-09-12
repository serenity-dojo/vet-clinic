# Vet Clinic Tutorial Project

This project is used as the basis of a number of tutorials and exercises, as part of the *Professional Java Development and Test Automation Skills* program (see http://johnfergusonsmart.com/products). Each tutorial explores a different technique or practice essential to modern Java developers or Engineers in Test. 

These tutorials are designed to be used as the basis of small coding exercises (similar to very short coding katas) that you can learn and practice until you are familiar with a particular technique. The approach is outlined here:

![Learning from the tutorials](src/documentation/images/tutorial-process.png)

1. Clone this repository and check out the starting point for the tutorial you want to do.
2. Watch the tutorial and follow along on your own machine.
3. Redo the tutorial following the step-by-step instructions given in the tutorial's README file.
4. Redo the exercise without the instructions.

## The problem domain

The domain is a simple one. We are writing an application for a Vet clinic, where you can take your pets to be treated when they are sick. At the vet clinic, we need to be able to register new animals when they arrive for treatment.

In the exercises for this tutorial we will be working with Screenplay Abilities.

## Exercise 1 - Check in guests at the start of the test using Abilities

The aim of this exercise is to create a new Ability to manage the hotel, and to use this ability to register guests with the hotel.

### Step 1 - Add a new actor

In the `WhenCheckingInToThePetHotel` class, go to the `petra_checks_her_cat_in_when_the_hotel_is_full()` method. Add a new actor called 'Harry the Hotel Manager':

```
Actor harry = Actor.named("Harry the hotel manager");
```

### Step 2 - Describe the actor

Harry the hotel manager can manage hotel registrations and guest lists. Give Harry the ability to manage the pet hotel using a new class `Manage` and a new factory method `Manage.the(petHotel)`:

```
harry.can(Manage.the(petHotel));
```

### Step 3 - Implement the factory class and method:

Create the `Manage` class and the `the()` method which should return a new `Ability` of type `ManageTheHotel`:

```
public class Manage {
    public static Ability the(PetHotel petHotel) {
        return new ManageTheHotel(petHotel);
    }
}
```

### Step 4 - Implement the `ManageTheHotel` class:

Create a new class `ManageTheHotel` that has a `PetHotel` field to manage:

```
public class ManageTheHotel implements Ability {
    private final PetHotel petHotel;

    public ManageTheHotel(PetHotel petHotel) {
        this.petHotel = petHotel;
    }
}
```

### Step 5 - Inject the test data
 
Delete the `PetHotel` instantiation (the line containing `APetHotel.with(20).petsCheckedIn()`), and replace it with a statement that Harry was able to fill the hotel with 20 cats, using the provide `FillTheHotel` class: 

```
        harry.wasAbleTo(
                FillTheHotel.with(20).cats()
        );
```

### Step 6 - Finish the `FillTheHotel` class

The `FillTheHotel` class is incomplete. Replace the line with the TODO comment with a statement that uses the actor's `ManageTheHotel` ability (that we assigned in the test case):

```
actor.usingAbilityTo(ManageTheHotel.class).checkInPet(pet);
```

### Step 7 - Implement the `checkInPet()` method  

Implement the `checkInPet()` method in the `ManageTheHotel` class, so that it calls the `petHotel` member variable:

```
    public void checkInPet(Pet pet) {
        petHotel.checkIn(pet);
    }
```

Ensure that the refactored test still runs.

## Exercise 2 - Query the guest list using Abilities

This exercise involves refactoring the questions in the `petra_checks_her_cat_in_when_the_hotel_is_full()` method, so that they use the Abilities rather than the `pethHotel` object directly.

### Step 1 - Make Harry more assertive

Replay the assertion section of the test (`petra.should(...)`) with `harry.should()`

### Step 2 - Add an assertion to check that Ginger the cat was not registered as a guest, e.g:

```
seeThat(TheGuests.registeredInTheHotel(), not(hasItem(ginger)))
```

### Step 3 - Implement the Question class

Create a new factory class called `TheGuests`, and a method called `registeredInTheHotel()`. Implement the `registeredInTheHotel()` using the `ManageTheHotel` ability, and adding the `getRegisteredPets()` method to the `ManageTheHotel` class:

```
public class TheGuests {
    public static Question<List<Pet>> registeredInTheHotel() {
        return actor -> actor.usingAbilityTo(ManageTheHotel.class)
                             .getRegisteredPets();
    }
}
```

# Step 4 - Implement the Activity method

Implement the `getRegisteredPets()` method using the `petHotel` object, e.g.

    public List<Pet> getRegisteredPets() {
        return petHotel.getPets();
    }

Ensure that the tests still run correctly.

## Exercise 3 - Query the waiting lists using Abilities

Use the same technique to add a check that Ginger the cat is in the waiting list:

```
seeThat(TheGuests.onTheWaitingList(), hasItem(ginger))
```
