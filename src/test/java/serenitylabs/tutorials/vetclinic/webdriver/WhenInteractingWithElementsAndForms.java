package serenitylabs.tutorials.vetclinic.webdriver;

import net.serenitybdd.core.annotations.findby.By;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class WhenInteractingWithElementsAndForms {
    WebDriver driver;

    @Before
    public void setup() {
        driver = new PhantomJSDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://www.sydneytrains.info/");
    }

    @Test
    public void entering_a_field_value() {

        // TODO: Enter 'Town Hall' into the 'From' field

        WebElement inputField = driver.findElement(By.id("display_origin"));
        inputField.sendKeys("Town Hall");

        String displayedValue = inputField.getAttribute("value");
        assertThat(displayedValue, equalTo("Town Hall"));
    }


    @Test
    public void click_on_a_button() {
        // TODO: Click on the View Trip button

        driver.findElement(By.id("display_origin")).sendKeys("Town Hall");
        driver.findElement(By.id("display_destination")).sendKeys("Parramatta");

        WebElement viewTrip =  driver.findElement(By.id("btnTripPlannerSubmit"));

        assertThat(viewTrip.isEnabled(), is(true));

        viewTrip.click();

        String title = driver.findElement(By.tagName("h1")).getText();
        assertThat(title, is("Plan your trip"));
    }

    @Test
    public void click_on_a_checkbox() {
        // TODO: Click on the Remember Me checkbox
        WebElement rememberMe = driver.findElement(By.id("chkRemember"));

        rememberMe.click();

        boolean rememberMeChoice = rememberMe.isSelected();
        assertThat(rememberMeChoice, is(true));
    }

    @Test
    public void click_on_a_radio_button() {

        WebElement leaveAfter = driver.findElement(By.cssSelector("[value='arr']"));

        // TODO: Choose the 'Leave After' option and make sure it is the one selected
        leaveAfter.click();

        assertThat(leaveAfter.isSelected(), is(true));

        String leaveOrArrivePreference = leaveAfter.getAttribute("value");

        assertThat(leaveOrArrivePreference, is("arr"));
    }


    @Test
    public void choose_a_dropdown_value() {
        // TODO: Click on 12pm

        Select dateList = new Select(driver.findElement(By.id("itdTimeHour")));

        dateList.selectByVisibleText("12");

        String selectedHour = dateList.getFirstSelectedOption().getText();

        assertThat(selectedHour, is("12"));
    }

    @After
    public void shutdown() {
        driver.quit();
    }
}
