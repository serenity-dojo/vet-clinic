package serenitylabs.tutorials.vetclinic.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class WhenAddingATodoItem {

    WebDriver chromedriver;

    @BeforeClass
    public static void setUpClass() {
     System.setProperty("webdriver.chrome.driver","C:\\Users\\siddharthk\\Downloads\\chromedriver_win32\\chromedriver.exe");
    }

    @Before
    public void setUp() throws Exception {
        chromedriver = new ChromeDriver();
        chromedriver.get("http://todomvc.com/examples/angularjs/#/");
        chromedriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void should_add_new_item_to_list() {
        WebElement newTodoElement = chromedriver.findElement(By.id("new-todo"));
        newTodoElement.sendKeys("Buy Some Milk");
        newTodoElement.sendKeys(Keys.RETURN);

        WebElement todoListElement = chromedriver.findElement(By.id("todo-list"));
        assertThat(todoListElement.getText(),containsString("Buy Some Milk"));

    }

    @After
    public void tearDown() throws Exception {
        chromedriver.quit();

    }
}
