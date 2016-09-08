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

These exercises involve working with the AngularJS TodoMVC web site (http://todomvc.com/examples/angularjs/#/).

### Exercise 1 - Write a test to add "Buy some milk" to the todo list
    
#### Step 1: Create a WebDriver instance and open the "http://todomvc.com/examples/angularjs/#/" URL.

Create a new Firefox webdriver instance:

    WebDriver driver = new FirefoxDriver();
    
Since this is an asynchronous application, configure WebDriver to wait up to 2 seconds if elements are not yet present on the page.

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     
Open the TodoMVC application:

    driver.get("http://todomvc.com/examples/angularjs/#/");
     
#### Step 2: Enter 'Buy some milk' into the todo field
    
Identify the todo input field on the web page and use the "Find By Id" strategy to locate it:
    
    WebElement inputField = driver.findElement(By.id("new-todo"));
    inputField.sendKeys("Buy some milk");

#### Step 3: Hit RETURN to add the todo item

Enter RETURN into the todo field:

    inputField.sendKeys(Keys.RETURN);

#### Step 4: Check the contents of the list

Use the `getText()` method to get the text of the list box:

    WebElement todoListContents = driver.findElement(By.id("todo-list"));
    assertThat(todoListContents.getText(), containsString("Buy some milk"));
        
#### Step 5: Close the browser

Close the browser using `driver.quit()`


   