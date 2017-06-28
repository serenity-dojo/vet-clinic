# Vet Clinic Tutorial Project

This project is used as the basis of a number of tutorials and exercises, as part of the *Professional Java Development and Test Automation Skills* program (see http://johnfergusonsmart.com/products). Each tutorial explores a different technique or practice essential to modern Java developers or Engineers in Test.

## Vet Clinic Tutorial 1 - The Builder Pattern

In this exercise we will learn about more expressive ways of creating new object instances using the Builder Pattern.

### Step 1 - Create a domain package.

First of all we need a place to store our domain model. Create a package called `domain` in the `serenitylabs.tutorials.vetclinic` package, in both `src/main/java` and `src/test/java`.

### Step 2 - Creating a Dog with a name

Lets start by seeing how we create a Dog.

  - First, add new class called `WhenWeCreateANewDog` in the `serenitylabs.tutorials.vetclinic.model` package under `src/test/java`.

  - Add a test called `a_new_dog_should_have_a_name()`, that demonstrates how you can create a new Dog instance with a given name. Use a simple default constructor and a String field `name` with a getter and setter.

### Step 3- Adding a date of birth
Add a 'date-of-birth' field to the Dog class:
  - Refactor your test and the Dog class to use a constructor that takes two parameters: `name` and `dateOfBirth`.

### Step 4- Adding a breed
Now we need to cater for the breed of the dog. We can do this by simply adding another field called 'breed'. We could add a third parameter to the constructor, and a fourth, and so on, but the constructor would start to get hard to read, and it would be easy to mix up the parameter order.

We need a more readable way of creating a dog, where the person using the Dog API can easily see what attributes are available, and a person reading the code can easily see what attributes were used to create a particular dog.

We'll do this using what's known as the Builder Pattern. The Builder Pattern is basically a fancy way of saying that you write a class whose job it is to build instances of another class.

 - Start by writing the builder expression that we would like to see as a user of our API. Try to make it as readable as possible. For example:
    ```
    Dog fido = Dog.called("Fido").ofBreed("Labrador").bornOn(theFourthOfJuly);
    ```

    - Generate the `called("Fido)` method and make it return a new instance of the `DogBreeder` class.
    - Create the `DogBreeder` class with a single `name` field.
    - Add the `ofBreed("Labrador")` to the `DogBreader` class and make it return the current `DogBreader` instance.
    - Add the `bornOn()` method that creates a new instance of `Dog` using a constructor with the three parameters, `name`,`breed`, and `dateOfBirth`.
    - Add the `breed` field to the `Dog` class.

### Step 5 - Add an optional colour field

Now we need to add a field for the colour of the dog. Colour is an optional field. Use interfaces to create an interface that caters for the mandatory fields (name, breed and date of birth) and the optional one (colour).

### Step 6 - Write a new builder

- Write a new builder for a new `Appointment` class. An appointment has a pet name, an owner, a time, and an optional reason. First, make the following test pass:
  ```
  private static final LocalDateTime TODAY_AT_2_PM = LocalDateTime.now().withHour(2).withMinute(0);

  @Test
  public void an_appointment_has_a_patient_name_an_owner_and_a_date() {
      Appointment appointment = Appointment.forPetCalled("Fido").ownedBy("Fred").at(TODAY_AT_2_PM);

      Assert.assertEquals("Fido",appointment.getPetName());
      Assert.assertEquals("Fred",appointment.getOwner());
      Assert.assertEquals(TODAY_AT_2_PM,appointment.getAppointmentTime());
  }
  ```

  - Next, let users provide an optional reason:
  ```
  public void an_appointment_can_have_an_optional_reason() {
    Appointment appointment = Appointment.forPetCalled("Fido").ownedBy("Fred").because("He is sick").at(TODAY_AT_2_PM);

    Assert.assertEquals(true,appointment.getReason().isPresent());
    Assert.assertEquals("He is sick",appointment.getReason().get());
  }
  ```
