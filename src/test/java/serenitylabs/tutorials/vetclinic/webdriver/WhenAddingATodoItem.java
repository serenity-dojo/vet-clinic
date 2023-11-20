package serenitylabs.tutorials.vetclinic.webdriver;

import net.bytebuddy.asm.Advice;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;

public class WhenAddingATodoItem {
    WebDriver driver = new FirefoxDriver();
    @Test
    public void should_add_new_item_to_list() {
        driver.get("https://todomvc.com/examples/angularjs/#/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement inputField = driver.findElement(By.className("new-todo"));
        inputField.sendKeys("Buy some milk");
        inputField.sendKeys(Keys.ENTER);
        WebElement toDoListItems = driver.findElement(By.className("ng-binding"));

        assertThat(toDoListItems.getText()).contains("Buy some milk");
        driver.quit();
    }

}
