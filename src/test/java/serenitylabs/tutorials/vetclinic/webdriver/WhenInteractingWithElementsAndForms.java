package serenitylabs.tutorials.vetclinic.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

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

        String displayedValue = null;
        assertThat(displayedValue, equalTo("Town Hall"));
    }


    @Test
    public void click_on_a_button() {
        // TODO: Click on the View Trip button

        String title = null;
        assertThat(title, is("Plan your trip"));
    }

    @Test
    public void click_on_a_checkbox() {
        // TODO: Click on the Remember Me checkbox

        Boolean rememberMeChoice = null;
        assertThat(rememberMeChoice, is(true));
    }

    @Test
    public void click_on_a_radio_button() {

        // TODO: Choose the 'Leave After' option and make sure it is the one selected

        String leaveOrArrivePreference = null;

        assertThat(leaveOrArrivePreference, is("arr"));
    }


    @Test
    public void choose_a_dropdown_value() {
        // TODO: Click on 12pm

        String selectedHour = null;

        assertThat(selectedHour, is("12"));
    }

    @After
    public void shutdown() {
        driver.quit();
    }
}
