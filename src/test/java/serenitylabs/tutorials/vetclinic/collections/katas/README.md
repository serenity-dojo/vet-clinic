# Collections Katas
 
## Booking pets into a pet hotel
 
The aim of this kata is to implement a Pet hotel with the following requirements:

  - Pet owners should be able to check their pet into the hotel
  - Pet owners should receive a confirmation that their pet has been successfully checked in
  - The hotel owner should be able to list all of the pets in the hotel in alphabetical order
  - The hotel should have a maximum capacity of 20 animals. 
  - When a pet owner checks in their pet and the hotel is full, they should receive a confirmation that their pet has been placed on a waiting list.
  - When a pet checks out of the hotel, the first animal on the waiting list should be automatically checked in.
  
When you first do the exercise, implement the features by progressively making all of the acceptance tests in the  pass, one after the other. The `WhenBookingPetsIntoAPetHotel` test class contains a sequence of unit tests for each feature to be implemented. The last line in each test is a Hamcrest assertion that is commented out. Uncomment the assertion, then follow the steps below to implement each feature and make the tests pass.

Once you have finished, repeat the exercise, but first deleting all of the tests and then rewriting them using a TDD approach (i.e. Write a failing test for a feature, make it pass, refactor the code, move to the next feature).

## The Steps

# Step 1 - Check a pet into the hotel (part 1)
_Test case:_ `the_hotel_should_initially_have_no_pets_booked()`

Create a new class `PetHotel` and give it a method `getPets()` that returns null. Make sure the test fails, then get the `getPets()` method to return an empty collection of `Pet` instances.

# Step 2 - Check a pet into the hotel (part 2)

_Test case:_ `should_be_able_to_check_a_pet_into_the_hotel()`

Add a method `checkIn()` to the `PetHotel` class, that takes a `Pet` as a parameter, and demonstrate that when you check a pet into the hotel, it can be retrieved via the `getPets()` method. Implement the list of pets in the `PetHotel` class as an `ArrayList`.

# Step 3 - Check a pet into the hotel (part 3)

_Test case:_ `should_be_able_to_check_in_several_pets()`

Demonstrate that you can check several pets into the hotel, and that they all can be retrieved via the `getPets()` method.

# Step 4 - Check a pet into the hotel (part 4)

_Test case:_ `should_not_be_able_to_check_in_the_same_pet_twice()`

Demonstrate that if you check in the same pet twice, it should have no effect on the current pet list. Refactor the pet list field to use a `TreeMap` instead of an `ArrayList`.

# Step 5 - Pet owners should receive a confirmation that their pet has been successfully checked in

_Test case:_ `should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet()`

Demonstrate that when an owner checks in a pet, they receive a `BookingResponse` object which contains a reference to the pet, a booking number, and a method `isConfirmed()` that returns `true`.


# Step 6 - The hotel owner should be able to list all of the pets in the hotel in alphabetical order

_Test case:_ `should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order()`

Make this work by refactoring the pet list field to use a `TreeMap` with a Java 8 comparator.
 
# Step 7 - The hotel should have a maximum capacity of 20 animals. 

_Test case:_ `should_not_be_able_to_check_in_pets_beyond_hotel_capacity()`

This test should check that when an owner checks in a pet when the hotel is full, the pet is not added to the pet list.

# Step 8

_Test case:_ `should_notify_owner_that_the_hotel_is_full()`

Ensure that when an owner checks in a pet to a full hotel, the hotel returns a `Response` that indicates that the booking is not confirmed (`isConfirmed()` returns false), and that the pet has been placed on a waiting list (via a new method, 'isOnWaitingList()` is true).

# Step 9

_Test case:_ `pets_on_the_waiting_list_should_be_added_to_the_hotel_when_a_place_is_freed()`

Ensure that when a pet checks out of the hotel, the first pet on the waiting list is automatically checked in.

# Step 10

_Test case:_ `pets_on_the_waiting_list_should_be_admitted_on_a_first_come_first_served_basis()`

Ensure that pets on the waiting list are checked in on a first-come-first-served basis.

