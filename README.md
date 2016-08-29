# Vet Clinic Tutorial Project

This project is used as the basis of a number of tutorials and exercises, as part of the *Professional Java Development and Test Automation Skills* program (see http://johnfergusonsmart.com/products). Each tutorial explores a different technique or practice essential to modern Java developers or Engineers in Test. 

This kata will help you become familiar with the Strategy pattern. 

## The domain: 

In this exercise we need to organise the weekly sporting activities of Bill, the son of the owner of the Pet Hotel. Bill plays football on weekends, and handball during the week, except on Wednesdays, when he plays sports for his school. At his school, he plays Cricket in summer months (June to September) and Tennis for the rest of the year.

You will implement a `Child` class with a single public method: `goPlayBallOn()`, which instructs the child to go and play his scheduled sport on a given day.

### Step 1 - Plays football on Sundays

Open the `WhenPlayingBall` test class, which will be your starting point for the exercise.


    static final LocalDate A_SUNDAY = LocalDate.of(2016, AUGUST, 28);

    @Test
    public void should_play_football_on_sundays() {
        Child bill = new Child();

        Game gamePlayed = bill.goPlayBallOn(A_SUNDAY);

        assertThat(gamePlayed, equalTo(Game.Football));
    }

Implement the `Child` class and the goPlayBallOn() method in the simplest possible way, e.g.

    public Game goPlayBallOn(LocalDate someDay) {
        return Game.Football;
    }

### Step 2 - Plays football on Saturdays

Write a similar test method, `should_play_football_on_saturdays()`, and make it pass in the simplest possible way.

### Step 3 - Plays handball during the week

Now write a test method, `should_play_handball_on_week_days()`, and make it pass.

### Step 4 - Plays tennis at school on Wednesdays

Now write a test method, `should_play_tennis_on_wednesdays()`. Make this test pass in the simplest possible way. 

### Step 5 - Refactor the `goPlayBallOn()` method using the Strategy pattern

You are now probably getting some non-trivial conditional logic in the `goPlayBallOn()` method. Use the strategy pattern to simplify the conditional logic in the `goPlayBallOn()` method:

  1) Write a `GameSchedule` interface, that has a single method:
     
         PlayBall forGameOn(LocalDate someDay)

  2) `PlayBall` is a simple interface with a single method: `play()`. Implement this interface, e.g.
        public interface PlayBall {
            Game play();
        }
        
  3) Implement the game schedule for recreational sports:
      - Write a test case `WhenSchedulingRecreationalSport` that contains methods `should_play_football_on_the_weekends()` and `should_play_handball_during_the_week`, and use these tests to build the `RecreationalSportSchedule` class.  
      - Implement the `RecreationalSportSchedule` class. You will need to add concrete implementations of the `PlayBall` strategy, e.g. `PlayFootball` and `PlayHandball`:
      
      public class RecreationalSportsSchedule implements GameSchedule {
          @Override
          public PlayBall forGameOn(LocalDate currentDay) {
              if ((currentDay.getDayOfWeek() == SATURDAY) || (currentDay.getDayOfWeek() == SUNDAY)) {
                  return new PlayFootball();
              }
              return new PlayHandball();
          }
      }
      
      An example of an implemented strategy class is:
      
          public class PlayFootball implements PlayBall {
          
              public Game play() {
                  return Game.Football;
              }
          }
      
  4) Implement the game schedule for school sports, e.g.
      - Write a test case `WhenSchedulingSchoolSports`
      - Write a test to check that tennis should be scheduled in Winter, and that Cricket should be scheduled in Summer.
      - (Advanced): Use a parameterized JUnit test to check sample dates for each month of the year.
    
   Again, you will need to implement any concrete implementations of `PlayBall` that you need for the school sports schedule.
  
  5) Refactor the `goPlayBallOn()` method to use the recreational and school sports schedulers. One possible implemention is shown here:
       
           public class Child {
           
               GameSchedule schoolSportScheduled = new SchoolSportsSchedule();
               GameSchedule recreationalSportScheduled = new RecreationalSportsSchedule();
               
               public Game goPlayBallOn(LocalDate someDay) {
                   if (someDay.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                       return schoolSportScheduled.forGameOn(someDay).play();
                   } else {
                       return recreationalSportScheduled.forGameOn(someDay).play();
                   }
               }
           }

### Step 6 - Externalise the final scheduling logic

In the above implementation, the child still has to know what day school sports are on. Refactor this code by creating a SportsSchedule class that encapsulates this logic, to simplify the Child class further, e.g.

        public class Child {
        
            private final SportsSchedule sportsSchedule;
        
            public Child(SportsSchedule sportsSchedule) {
                this.sportsSchedule = sportsSchedule;
            }
        
            public Game goPlayBallOn(LocalDate someDay) {
                return sportsSchedule.forDate(someDay).play();
            }
        }

Make sure all of the tests still pass!