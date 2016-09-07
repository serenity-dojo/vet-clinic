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

## Exercises

These exercises involve working with the Sydney Trains web site (http://www.sydneytrains.info). 
The test skeletons for these exercises can be found in the `WhenInteractingWithElementsAndForms` class.

### Exercise 1 - Enter a text value into a field

Write a test that enters 'Town Hall' into the 'From' field in the 'Plan Your Trip' form.

### Exercise 2 - Enter a text value into a field

Write a test that enters 'Town Hall' into the 'From' field, 'Parramatta' into the 'To' field, and clicks on 'View Trip'.

### Exercise 3 - Checkboxes

Write a test that checks the 'Remember me' checkbox.

### Exercise 4 - Radio buttons

Write a test that selects the 'Arrive before' option.

### Exercise 5 - Dropdown lists

Write a test that selects "12" in the departure hour.


## Kata

The coding kata for this lesson involves writing a complete test to simulate a user planning a trip from Town Hall to Parramatta, 
arriving tomorrow before 10:15am. On the result page, check that more than one trip option is displayed and that all of the 
search preferences are also correctly displayed, including:
   - From and To stations
   - Leave after/arrive before preference
   - Arrival Hour and minute
   - Arrival Day
    
    