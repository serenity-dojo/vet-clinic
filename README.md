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

In the exercises for this tutorial we will be writing basic tests using the Screenplay pattern.

## Exercise 1 - checking in to a pet hotel

### Step 1
Create a test class called `WhenCheckingInToThePetHotel` with a test method `petra_books_her_pet_cat_into_the_hotel()`. Configure the test to run with the `SerenityRunner` class:

```
@RunWith(SerenityRunner.class)
public class WhenCheckingInToThePetHotel {

    @Test
    public void petra_books_her_pet_cat_into_the_hotel() {
    }
}
```

### Step 2
Implement the test so that it demonstrates that when Petra checks in her pet cat, the cat appears in the list of registered guests, e.g:

```
    // GIVEN

    Actor petra = Actor.named("Petra the pet owner");
    Pet ginger = Pet.cat().named("Ginger");
    PetHotel petHotel = PetHotel.called("Pet Hotel California");

    // WHEN
    petra.attemptsTo(
            CheckIn.aPet(ginger).into(petHotel)
    );

    // THEN
    assertThat(petHotel.getPets(), hasItem(ginger));

```

### Step 3
Implement the CheckIn class using a builder pattern.

```
public class CheckIn implements Performable {
    private final Pet pet;
    private final PetHotel petHotel;

    public CheckIn(Pet pet, PetHotel petHotel) {
        this.pet = pet;
        this.petHotel = petHotel;
    }

    public <T extends Actor> void performAs(T actor) {}

    public static CheckInBuilder aPet(Pet pet) {
        return new CheckInBuilder(pet);
    }

    public static class CheckInBuilder {
        private final Pet pet;

        public CheckInBuilder(Pet pet) {
            this.pet = pet;
        }

        public Performable into(PetHotel petHotel) {
            return new CheckIn(pet, petHotel);
        }
    }
}
```

### Step 4
Implement the `performAs()` method to contain the correct business logic:


```
    public <T extends Actor> void performAs(T actor) {
        petHotel.checkIn(pet);
    }
```

You should now be able to run the test.

### Step 5
Add instrumentation to the builder:

```
        public Performable into(PetHotel petHotel) {
            return Instrumented.instanceOf(CheckIn.class).withProperties(pet, petHotel);
        }
```

### Step 6
Add the `@Step` annotation to the `performAs()` method:

```
    @Step("{0} checks #pet into #petHotel")
    @Override
    public <T extends Actor> void performAs(T actor) {
        petHotel.checkIn(pet);
    }
```

Now run the test and check that the correct reporting appears in the Serenity HTML report in the `target/site/serenity` directory.

## Exercise 2 - checking out of the hotel

### Step 1

Write a new test called `petra_checks_her_cat_out_of_the_hotel()`. In the GIVEN section, use the `wasAbleTo()` method of the `Actor` class to execute a task as part of the test setup:

```
        // GIVEN

        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = PetHotel.called("Pet Hotel California");

        petra.wasAbleTo(CheckIn.aPet(ginger).into(petHotel));
```

### Step 2

Write the rest of the test body, where Petra checks her pet out and verifies that her pet is no longer registered at the hotel:

```
        // WHEN
        petra.attemptsTo(
                CheckOut.aPet(ginger).from(petHotel)
        );

        // THEN
        assertThat(petHotel.getPets(), not(hasItem(ginger)));
```

### Step 3

Implement the CheckOut class (don't copy-paste!):

   - Create the `CheckOut` class
   - Make it extend `Performable`
   - Implement the `aPet()` method and make it return a `CheckOutBuilder` instance
   - Create the `CheckOutBuilder` class
   - Implement the `from()` method to return an instrumented instance of the `CheckOut` class.
   - Add the `pet` and `petHotel` fields to the `CheckOut` class, and a constructor to initialise them.
   - Implement the `performAs()` method.
   
Now run the test and check that the correct reporting appears in the Serenity HTML report in the `target/site/serenity` directory.
