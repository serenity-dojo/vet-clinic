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

In the exercises for this tutorial we will be working with Screenplay Questions.

## Exercise 1 - refactoring a test to use a Question

Refactor the `petra_checks_her_cat_out_of_the_hotel()` test to use a Question instead of an annotation. 

## Exercise 2 - writing a new Question

Write a new test `petra_checks_her_cat_in_when_the_hotel_is_full()`. This test should use the `APetHotel` class to create a new hotel with a number of guests already present:

```
PetHotel petHotel = APetHotel.with(20).petsCheckedIn();
```

The test should use a question to confirm that Petra's pet cat Ginger is not in the hotel guest list, but has been placed on the waiting list.