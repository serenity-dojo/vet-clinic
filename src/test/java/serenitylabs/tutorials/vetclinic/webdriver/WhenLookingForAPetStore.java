package serenitylabs.tutorials.vetclinic.webdriver;

import net.serenitybdd.core.annotations.findby.By;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WhenLookingForAPetStore {
    @Test
    public void should_find_pet_stores() {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://duckduckgo.com/");

        WebElement input = driver.findElement(By.id("search_form_input_homepage"));

        input.sendKeys("pet store");

        WebElement searchButton = driver.findElement(By.id("search_button_homepage"));
        searchButton.click();

        assertThat(driver.getTitle(), equalTo("pet store at DuckDuckGo"));

        driver.quit();
    }
}

