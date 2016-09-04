package serenitylabs.tutorials.vetclinic.webdriver;

import net.serenitybdd.core.annotations.findby.By;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WhenLocatingElements {
    WebDriver driver;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://todomvc.com/examples/dojo");
    }

    @Test
    public void finding_the_new_todo_field_by_id() {
        // TODO: Find the New Todo field by ID
        WebElement todoField = null;

        assertThat(todoField.getAttribute("placeholder"), equalTo("What needs to be done?"));
    }

    @Test
    public void finding_the_quote_by_tag() {
        // TODO: Find the Quote field by its HTML tag
        WebElement quote = null;

        assertThat(quote.getText(), containsString("Dojo saves you time"));
    }


    @Test
    public void finding_the_source_link_by_link_text() {
        // TODO: Find the 'Source' link by link text
        WebElement completedButton = null;

        assertThat(completedButton.getText(), equalTo("Source"));
    }

    @Test
    public void finding_the_new_todo_field_by_css() {
        // TODO: Find the New Todo field by CSS
        WebElement todoField = null;

        assertThat(todoField.getAttribute("placeholder"), equalTo("What needs to be done?"));
    }

    @Test
    public void finding_the_new_todo_field_by_class() {
        // TODO: Find the Quote text by classname
        WebElement quote = null;

        assertThat(quote.getText(), containsString("Dojo saves you time"));
    }

    @Test
    public void finding_the_quote_by_css() {
        // TODO: Find the Quote field using a CSS selector
        WebElement quote = null;

        assertThat(quote.getText(), containsString("Dojo saves you time"));
    }

    @Test
    public void finding_the_new_todo_field_by_xpath() {
        // TODO: Find the New Todo field by XPath
        WebElement todoField = null;

        assertThat(todoField.getAttribute("placeholder"), equalTo("What needs to be done?"));
    }


    @Test
    public void finding_the_todo_entries_by_css() {
        addTodo("Buy some milk");
        addTodo("Walk the dog");
        addTodo("Feed the cat");

        // TODO: Use the findElements method to find a list of WebElements corresponding to the todo list entries
        List<WebElement> todoItems = null;

        assertThat(todoItems.size(), equalTo(3));
    }

    private void addTodo(String item) {
        WebElement todoInputField = driver.findElement(By.cssSelector("#new-todo"));
        todoInputField.sendKeys(item);
        todoInputField.sendKeys(Keys.RETURN);
    }

    @After
    public void shutdown() {
        driver.quit();
    }
}
