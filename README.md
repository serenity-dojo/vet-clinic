# Vet Clinic Tutorial Project

This project is used as the basis of a number of tutorials and exercises, as part of the *Professional Java Development and Test Automation Skills* program (see http://johnfergusonsmart.com/products). Each tutorial explores a different technique or practice essential to modern Java developers or Engineers in Test. 

## Vet Clinic Tutorial 3 - Polymorphism

In this exercise we will learn about using polymorphism in Java.

### Step 1 - Add a new test class
Create a new test class called WhenCollectingAnimals and add a test called `a_list_of_animals_can_contain_cats_and_dogs`. This class should illustrate how you can add a cat and a dog to a list of animals, of type `List<Animal>`. Create an empty Animal class, and make sure the test fails.

### Step 2 - Cats and Dogs are Animals

Make the Cat and Dog class extend the Animal class. This should make your test pass.

### Step 3 - Adding a polymorphic method

Create a new test called `a_dog_complains_by_growling` and make it pass. The assertion should look like this:
```
assertThat(fido.complaint(), is(equalTo("Grrrr")));
```

### Step 4 - Cats meow

Create a new test called `a_cat_complains_by_meowing` and make it pass. The assertion should look like this:
```
assertThat(felix.complaint(), is(equalTo("Meow")));
```

### Step 5 - Animals complain

Add an abstract `complain()` method to the Animal class. 

Demonstrate that this works in a test called `cats_and_dogs_complain_to_the_assistant`. Create a `ComplaintRegister` class and a `VetAssistant` class, and illustrate in your test that dogs and cats complain differently. For example:

```
...
ComplaintRegister complaintRegister = new ComplaintRegister();
VetAssistant assistant = new VetAssistant(complaintRegister);

assistant.recordComplainFrom(fido)
assistant.recordComplainFrom(felix)
assertThat(complaintRegister.getComplains(), hasItems("Grrrr", Meow");

```

# Step 6 Vaccinations 

Write a new test called `the_vet_should_know_when_a_pet_vaccination_is_due`. Assuming that dogs need vaccinations every 6 months and cats need vaccintions every 12 months, do this with polymorphism using interfaces, and by creating a `NeedsVaccination` interface.