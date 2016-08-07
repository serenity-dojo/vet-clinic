# Vet Clinic Tutorial Project

This project is used as the basis of a number of tutorials and exercises, as part of the *Professional Java Development and Test Automation Skills* program (see http://johnfergusonsmart.com/products). Each tutorial explores a different technique or practice essential to modern Java developers or Engineers in Test. 

## Vet Clinic Tutorial 2 - Hamcrest Matchers

In this exercise we will learn about more expressive ways of writing assertions with Hamcrest matchers

### Step 1 - Replace JUnit asserts with Hamcrest asserts

Open the `WhenCalculatingTotalPrices` class and replace the JUnit assert statement in `total_consultation_price_should_include_20_percent_tax()` with an equivalent Hamcrest assertion.

### Step 2 - Hamcrest comparaison assertions

Replace the `equalTo` matcher with a `greaterThan` matcher.

### Step 3 - Hamcrest String matchers

Write a new test to check that when you create a new Dog instance, the toString() method should return a sentence like "Fido the black laborador". Write Hamcrest checks to verify that the string:
    - Starts with the name of the dog, 
    - Ends with the breed, and
    - Contains the colour.
    
### Step 4 - Hamcrest collection matchers

Modify the code to allow dogs to have more than one colour. Write a new test called `a_dog_can_have_several_colours()` to drive this, and check the results with the Hamcrest collection matchers.